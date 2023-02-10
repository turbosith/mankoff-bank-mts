package mtsbank.evdokimov.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DispatcherServlentConfiguration extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[0](SpringMVCConfiguration.class);
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
