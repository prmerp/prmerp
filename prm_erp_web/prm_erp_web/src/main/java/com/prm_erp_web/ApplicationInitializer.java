package com.prm_erp_web;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 *
 * @author PDP_Shiva
 */
public class ApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class< ?>[] getRootConfigClasses() {
        return new Class[]{
            ApplicationConfiguration.class
        };
    }

    @Override
    protected Class< ?>[] getServletConfigClasses() {
        return null;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{
            "/rest/*"
        };
    }

    @Override
    protected void customizeRegistration(Dynamic registration) {

        //Parameters:-
        //   location - the directory location where files will be stored
        //   maxFileSize - the maximum size allowed for uploaded files
        //   maxRequestSize - the maximum size allowed for multipart/form-data requests
        //   fileSizeThreshold - the size threshold after which files will be written to disk
        MultipartConfigElement multipartConfig = new MultipartConfigElement("D:/", 1048576,
                10485760, 0);
        registration.setMultipartConfig(multipartConfig);
    }

}
