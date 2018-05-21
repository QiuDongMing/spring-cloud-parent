package com.qdm.mq;

import com.qdm.mq.conf.MqConfig;
import com.qdm.mq.exception.MqException;
import com.rabbitmq.client.*;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author qiudm
 * @date 2018/5/11 19:07
 * @desc
 */
@Component
@Scope("singleton")
public class ConnectionManager {
    private static final Logger logger = LoggerFactory.getLogger(ConnectionManager.class);
    private static ConnectionManager manager = null;
    @Autowired
    private MqConfig rabbitMqConfig;

    private ConnectionManager() {
        manager = this;
    }

    public static ConnectionManager getInstance() {
        return manager;
    }

    public Connection newConnection(ThreadFactory facotry, int timeout, String instanceName) {
        ConnectionFactory connectionFactory = this.getConnectionFactory(instanceName);
        String addressStr = MqConfig.getAddresses(instanceName);
        Address[] address = null;
        if (StringUtils.isNotEmpty(addressStr)) {
            address = Address.parseAddresses(addressStr);
        }

        if (facotry != null) {
            connectionFactory.setThreadFactory(facotry);
        }

        Connection connection = null;
        long startTime = System.currentTimeMillis();

        while (connection == null) {
            try {
                if (timeout > 0 && System.currentTimeMillis() - startTime > (long) timeout) {
                    logger.error("mq connect is timeout!");
                    return null;
                }

                if (address != null) {
                    connection = connectionFactory.newConnection(address);
                } else {
                    connection = connectionFactory.newConnection();
                }
            } catch (TimeoutException var12) {
                logger.error(var12.getMessage());
            } catch (Throwable var13) {
                connection = null;
                logger.error(var13.getMessage());
            }

            if (connection == null) {
                try {
                    Thread.sleep(2000L);
                } catch (Throwable var11) {
                    logger.error(var11.getMessage());
                }
            }
        }

        connection.addShutdownListener(new ShutdownListener() {
            public void shutdownCompleted(ShutdownSignalException cause) {
                String hardError = "";
                String applInit = "";
                if (cause.isHardError()) {
                    hardError = "connection";
                } else {
                    hardError = "channel";
                }

                if (cause.isInitiatedByApplication()) {
                    applInit = "application";
                } else {
                    applInit = "broker";
                }

                ConnectionManager.logger.warn("Connectivity to MQ has failed.  It was caused by {} at the {} level.  Reason received {}", new Object[]{hardError, applInit, cause.getReason()});
            }
        });
        return connection;
    }

    private synchronized void waitAndReconnect(Connection connection, int timeOutSeconds) {
        int i = 0;

        while (true) {
            try {
                TimeUnit.SECONDS.sleep(1L);
                ++i;
                if (connection.isOpen() || timeOutSeconds > 0 && i >= timeOutSeconds) {
                    return;
                }

                logger.warn("try reconnection again later... ");
            } catch (InterruptedException var5) {
                var5.printStackTrace();
            }
        }
    }

    private ConnectionFactory getConnectionFactory(String instanceName) {
        if (!MqConfig.isEnable(instanceName)) {
            logger.error("请检查配置文件");
            throw new MqException("配置错误");
        } else {
            ConnectionFactory connectionFactory = new ConnectionFactory();
            connectionFactory.setHost(MqConfig.getHost(instanceName));
            connectionFactory.setPort(MqConfig.getPort(instanceName));
            connectionFactory.setUsername(MqConfig.getUsername(instanceName));
            connectionFactory.setPassword(MqConfig.getPassword(instanceName));
            connectionFactory.setConnectionTimeout(MqConfig.getConnectionTimeout(instanceName));
            connectionFactory.setRequestedHeartbeat(MqConfig.getRequstHeartbeat(instanceName));
            connectionFactory.setAutomaticRecoveryEnabled(true);
            connectionFactory.setNetworkRecoveryInterval(5000);
            return connectionFactory;
        }
    }
}



