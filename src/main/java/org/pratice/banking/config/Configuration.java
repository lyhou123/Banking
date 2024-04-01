package org.pratice.banking.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@org.springframework.context.annotation.Configuration
public class Configuration implements WebMvcConfigurer {
    @Value("${file.storage_dir}")
    String filelocation;
    @Value("${file.client}")
    String client;
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(client).addResourceLocations("file:"+filelocation);
    }
}
