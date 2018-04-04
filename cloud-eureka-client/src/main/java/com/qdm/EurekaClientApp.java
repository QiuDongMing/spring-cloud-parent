package com.qdm;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author qiudm
 * @date 2018/3/22 17:52
 * @desc 作为服务提供方
 */
@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan({"com.qdm","org.springframework.data.mongodb"})
@EnableScheduling
public class EurekaClientApp {
    public static void main(String[] args) {
        new SpringApplicationBuilder(EurekaClientApp.class).web(true).run();
    }
}
