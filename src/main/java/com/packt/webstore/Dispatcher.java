package com.packt.webstore;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.packt.webstore.interceptor.NoticeInterceptor;
 
@EnableWebMvc
@Configuration
@ComponentScan(basePackages = { "com.packt.webstore.controller" })
@PropertySource(value="classpath:application.properties")
public class Dispatcher extends WebMvcConfigurerAdapter {
 
	@Autowired 
	Environment environment;
	
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(environment.getProperty("staticResourceAlias")).addResourceLocations(environment.getProperty("staticResourceLocation"));
    }
 
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
 
    @Bean
    public InternalResourceViewResolver jspViewResolver() {
        InternalResourceViewResolver bean = new InternalResourceViewResolver();
        bean.setPrefix(environment.getProperty("viewResolver.prefix"));
        bean.setSuffix(environment.getProperty("viewResolver.suffix"));
        return bean;
    }
 
    @Override
    public void addInterceptors(InterceptorRegistry registry) 
    {
    	registry.addInterceptor(new NoticeInterceptor())
              	.addPathPatterns("/employees/list");
      	LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
	  	localeChangeInterceptor.setParamName("language");
	    registry.addInterceptor(localeChangeInterceptor);
    }

    @Bean(name = "messageSource")
    public ReloadableResourceBundleMessageSource messageSource() {
        ReloadableResourceBundleMessageSource resource = new ReloadableResourceBundleMessageSource();
        resource.setBasename("classpath:messages");
        resource.setDefaultEncoding("UTF-8");
        return resource;
    }
  
    @Bean(name = "validator")
    public LocalValidatorFactoryBean validator() {
       LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
       bean.setValidationMessageSource(messageSource());
       return bean;
    }
    
    @Override
    public Validator getValidator(){
       return validator();
    }

	@Bean
	public LocaleResolver localeResolver(){
		   SessionLocaleResolver resolver = new SessionLocaleResolver();
		   resolver.setDefaultLocale(new Locale("en"));
	   return resolver;
	}
//	kaleb added
//	@Override
//	  public void addViewControllers(ViewControllerRegistry registry) {
//	    registry.addViewController("/").setViewName("index");
//	  }

   
    
    
}
