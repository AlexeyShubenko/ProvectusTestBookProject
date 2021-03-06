package com.testbook.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Created by Alexey on 20.05.2017.
 */
@Configuration
public class JspConfig {

    @Bean
    public InternalResourceViewResolver getViewResolver() {
        // Где искать jsp файлы
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

}
