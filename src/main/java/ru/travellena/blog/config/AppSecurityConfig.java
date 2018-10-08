package ru.travellena.blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		// Organizing in-memory security
		
		UserBuilder users = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
			.withUser(users.username("master").password("qwe123").roles("ADMIN"))
			.withUser(users.username("holder").password("qwe123").roles("ADMIN"));
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
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
