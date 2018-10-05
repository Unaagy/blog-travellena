package ru.travellena.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * 
 * @author tuchnyak, https://github.com/Tuchnyak
 *
 * @About Spring MVC web-application with Hibernate ORM implementation in form
 *        of blog platform
 * @Attention NO XML!
 * @Description Configuration class for ORM, ViewResolver, etc.
 */
@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan("ru.travellena.blog")
public class AppConfig implements WebMvcConfigurer {
	// watch to:
	/*
	 * /home/tuchnyak/myProjects/training/UdemySpringAndHibernateForBeginners/
	 * Security/spring-crm-rest-security/src/main/java/com/luv2code/springdemo/
	 * config
	 */

	/**
	 * Configuring ViewResolver
	 */
	@Bean
	public ViewResolver viewResolver() {

		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}

	/**
	 * Handles static resources folders
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
		
	}
	
	

}
