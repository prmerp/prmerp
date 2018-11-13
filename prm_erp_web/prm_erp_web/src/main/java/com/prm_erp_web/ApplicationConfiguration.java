/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prm_erp_web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prm_erp_web.hibernateConfig.HibernateConfigs;
import java.io.IOException;
import javax.servlet.annotation.MultipartConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 *
 * @author PDP_Shiva
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.prm_erp_web")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, // 10 MB 
        maxFileSize = 1024 * 1024 * 50, // 50 MB
        maxRequestSize = 1024 * 1024 * 100)   	// 100 MB
@Import(HibernateConfigs.class)
public class ApplicationConfiguration {

    public static final String ENCODING_UTF_8 = "UTF-8";

    public static final long MAX_UPLOAD_FILE_SIZE = 52428807;

    public static final long MAX_UPLOAD_PER_FILE_SIZE = 5242880;

    /* CommonsMultipartResolver class provide function that can parse and get the upload file name, data etc. */
    @Bean(name = "multipartResolver")
    public StandardServletMultipartResolver getMultipartFormResolver() throws IOException {

        StandardServletMultipartResolver ret = new StandardServletMultipartResolver();

        return ret;
    }

    @Bean
    public ObjectMapper jsonMapper() {
        return new ObjectMapper();
    }
}
