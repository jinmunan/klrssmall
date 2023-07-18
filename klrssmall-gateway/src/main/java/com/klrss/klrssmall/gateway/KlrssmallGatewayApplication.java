package com.klrss.klrssmall.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: zhongnan
 */
@EnableDiscoveryClient
@SpringBootApplication
public class KlrssmallGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(KlrssmallGatewayApplication.class, args);
    }
}
