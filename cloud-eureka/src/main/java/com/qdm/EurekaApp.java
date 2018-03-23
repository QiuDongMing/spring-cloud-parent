package com.qdm;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author qiudm
 * @date 2018/3/22 17:28
 * @desc 作为服务的注册中心
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaApp {

    public static void main(String[] args) {
        new SpringApplicationBuilder(EurekaApp.class).web(true).run(args);
    }

}
