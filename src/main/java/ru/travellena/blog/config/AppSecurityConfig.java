package ru.travellena.blog.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource securityDataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.jdbcAuthentication().dataSource(securityDataSource);
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		/**
		 * Encoding Filters to make Cyrillic acceptable for form submition
		 */
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		characterEncodingFilter.setForceEncoding(true);
		http.addFilterBefore(characterEncodingFilter, CsrfFilter.class);
		
		/**
		 * Configuring access
		 */
		http.authorizeRequests()
			.antMatchers("/article/showDrafts")
				.hasRole("ADMIN")
			.antMatchers("/article/showFormForAdd")
				.hasRole("ADMIN")
			.antMatchers("/article/showFormForUpdate")
				.hasRole("ADMIN")
			.antMatchers("/article/saveArticle")
				.hasRole("ADMIN")
			.antMatchers("/article/delete")
				.hasRole("ADMIN")
			.and()
			.formLogin()
				.loginPage("/showLoginBlogPage")
				.loginProcessingUrl("/authenticateTheUser")
				.permitAll()
			.and()
			.logout()
				.permitAll();
		
	}

}
