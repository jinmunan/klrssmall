package com.klrss.klrssmall.thirdserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: zhongnan
 */
@EnableDiscoveryClient
@SpringBootApplication
public class KlrssmallThirdServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(KlrssmallThirdServerApplication.class, args);
    }
}
