package ru.travellena.blog.config;

import java.beans.PropertyVetoException;
import java.util.Properties;
import java.util.logging.Logger;

import javax.sql.DataSource;
import javax.transaction.TransactionManager;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * Spring MVC web-application with Hibernate ORM implementation in form of blog
 * platform
 * 
 * @author tuchnyak, https://github.com/Tuchnyak
 * 
 * @Attention NO XML!
 */
@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan("ru.travellena.blog")
@PropertySource({ "classpath:persistence-mysql.properties", "classpath:jdbc-mysql.properties" })
public class AppConfig implements WebMvcConfigurer {

	/**
	 * property information holder
	 */
	@Autowired
	private Environment env;

	private Logger logger = Logger.getLogger(getClass().getName());

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
	 * Security data source bean
	 * 
	 * @return ComboPooledDataSource object
	 */
	@Bean
	public DataSource securityDataSourse() {

		ComboPooledDataSource sds = new ComboPooledDataSource();

		try {
			sds.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException e) {
			throw new RuntimeException(e);
		}

		logger.info("===>>> jdbc.url=" + env.getProperty("jdbc.url"));
		logger.info("===>>> jdbc.user=" + env.getProperty("jdbc.user"));

		sds.setJdbcUrl(env.getProperty("jdbc.url"));
		sds.setUser(env.getProperty("jdbc.user"));
		sds.setPassword(env.getProperty("jdbc.password"));

		sds.setInitialPoolSize(Integer.parseInt(env.getProperty("connection.pool.initialPoolSize")));
		sds.setMinPoolSize(Integer.parseInt(env.getProperty("connection.pool.minPoolSize")));
		sds.setMaxPoolSize(Integer.parseInt(env.getProperty("connection.pool.maxPoolSize")));
		sds.setMaxIdleTime(Integer.parseInt(env.getProperty("connection.pool.maxIdleTime")));

		return sds;
	}

	/*
	 * Configuring Hibernate
	 */
	/**
	 * 
	 * @return hibernate properties from persistence configuration file
	 */
	private Properties getHibernateProperties() {

		Properties props = new Properties();

		props.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
		props.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		props.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));

		return props;
	}

	/**
	 * Configures session factory
	 * 
	 * @return LocalSessionFactoryBean object
	 */
	@Bean
	public LocalSessionFactoryBean sessionFactory() {

		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();

		sessionFactoryBean.setDataSource(securityDataSourse());
		sessionFactoryBean.setPackagesToScan(env.getProperty("hibernate.packagesToScan"));
		sessionFactoryBean.setHibernateProperties(getHibernateProperties());

		return sessionFactoryBean;
	}

	@Bean
	@Autowired
	public HibernateTransactionManager TransactionManager(SessionFactory sessionFactory) {

		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);

		return txManager;
	}

	/**
	 * Handles static resources folders
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");

	}

}
