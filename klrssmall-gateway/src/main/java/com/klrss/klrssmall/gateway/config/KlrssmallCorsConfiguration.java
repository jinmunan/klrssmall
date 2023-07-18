package com.klrss.klrssmall.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

/**
 * @author: zhongnan
 * 解决请求跨域问题
 * http://localhost:8001/#login 去访问 http://localhost:88/api/sys/login
 * 同源策略：协议、域名、端口都要相同
 */
@Configuration
public class KlrssmallCorsConfiguration {

    /**
     * 跨域解决办法之一：
     * 过滤器，给所有请求增加请求头信息
     * 使得预检请求通过
     */
    @Bean
    public CorsWebFilter corsWebFilter() {
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        // 配置跨越允许任意请求头
        corsConfiguration.addAllowedHeader("*");
        // 允许任意方法
        corsConfiguration.addAllowedMethod("*");
        // 允许任意请求来源
        corsConfiguration.addAllowedOriginPattern("*");
        // 允许携带cookie
        corsConfiguration.setAllowCredentials(true);
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsWebFilter(urlBasedCorsConfigurationSource);
    }
}
