package com.klrss.klrssmall.coupon;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: zhongnan
 */
@MapperScan("com.klrss.klrssmall.coupon.dao")
@SpringBootApplication
@EnableDiscoveryClient
public class KlrssmallCouponApplication {
    public static void main(String[] args) {
        SpringApplication.run(KlrssmallCouponApplication.class, args);
    }
}
