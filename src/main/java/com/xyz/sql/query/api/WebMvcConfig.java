package com.xyz.sql.query.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Web全局设置
 *
 * @author xyz
 * @date 2020/8/21
 */
@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 跨域配置
     */
    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        // 放行哪些原始域
        config.addAllowedOrigin("*");
        // 是否允许证书（允许携带Cookie 无需Cookie关闭即可）
        config.setAllowCredentials(true);
        // 放行哪些原始域(请求方式)
        config.addAllowedMethod("*");
        // 放行哪些原始域(头部信息)
        config.addAllowedHeader("*");

        // 添加映射路径
        UrlBasedCorsConfigurationSource configSource = new UrlBasedCorsConfigurationSource();
        configSource.registerCorsConfiguration("/sql/**", config);
        return new CorsFilter(configSource);
    }

    /**
     * 这里配置静态资源文件的路径导包都是默认的直接导入就可以
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // http://{ip}:{port}/swagger-ui.html
        registry.addResourceHandler("swagger-ui.html").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX + "/META-INF/resources/");

        registry.addResourceHandler("/webjars/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX + "/META-INF/resources/webjars/");
        registry.addResourceHandler("/static/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX + "/static/");
    }

}