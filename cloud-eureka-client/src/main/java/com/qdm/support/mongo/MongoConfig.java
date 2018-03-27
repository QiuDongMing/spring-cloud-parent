package com.qdm.support.mongo;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PreDestroy;

/**
 * @author qiudm
 * @date 2018/3/26 11:22
 * @desc
 */
@Configuration
public class MongoConfig {

    private static final Logger log = LoggerFactory.getLogger(MongoConfig.class);

    @Autowired
    private MongoProperties mongoProperties;


    @Bean(name = "mgdataSource")
    public Datastore dfForDw() {
        MongoClientOptions.Builder builder = MongoClientOptions.builder();
        builder.connectTimeout(5000);
        builder.socketKeepAlive(true);
        builder.socketTimeout(0);
        builder.heartbeatFrequency(3000);//心跳频率
        log.debug("mongo uri:{}",mongoProperties.getUri());

        MongoClientURI mongoClientURI = new MongoClientURI(mongoProperties.getUri(), builder);
        MongoClient mongoClient = new MongoClient(mongoClientURI);

        Morphia morphia = new Morphia();
        return  morphia.createDatastore(mongoClient, mongoProperties.getDbName());
    }

    @PreDestroy
    public void close(){
        log.info("mongoClient is destroy");
    }


}
