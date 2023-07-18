package com.klrss.klrssmall.member;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author: zhongnan
 */
@MapperScan("com.klrss.klrssmall.member.dao")
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.klrss.klrssmall.member.feign")
public class KlrssmallMemberApplication {
    public static void main(String[] args) {
        SpringApplication.run(KlrssmallMemberApplication.class, args);
    }
}
