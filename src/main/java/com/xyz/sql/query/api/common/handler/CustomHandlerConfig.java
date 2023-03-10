package com.xyz.sql.query.api.common.handler;

import com.xyz.sql.query.api.common.handler.returnn.AutoResultReturnHandler;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import javax.annotation.Resource;
import java.util.List;

/**
 * 处理器配置
 * <p>
 * 实现InitializingBean的bean在启动时都会被执行afterPropertiesSet
 * 源码 {@link org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory#invokeInitMethods}
 *
 * @author xyz
 * @date 2021/10/28
 **/
@Configuration
@Slf4j
public class CustomHandlerConfig implements InitializingBean {

    @Resource
    RequestMappingHandlerAdapter requestMappingHandlerAdapter;

    @Override
    public void afterPropertiesSet() {
        // expand return value handler
        List<HandlerMethodReturnValueHandler> returnValueHandlers = requestMappingHandlerAdapter.getReturnValueHandlers();
        List<HandlerMethodReturnValueHandler> list = Lists.newArrayList();
        HandlerMethodReturnValueHandler autoResultReturnHandler = new AutoResultReturnHandler();
        log.info("BaseWebMvcConfig expand return value handler end");
    }

}
