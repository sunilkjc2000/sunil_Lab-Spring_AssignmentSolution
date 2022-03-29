package com.greatlearning.smsappassignment.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;


@SuppressWarnings("deprecation")
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	    @Autowired
	    public void configure(AuthenticationManagerBuilder auth)
	    throws Exception {
	        auth.inMemoryAuthentication()
	            .passwordEncoder(NoOpPasswordEncoder.getInstance())
	            .withUser("admin").password("admin").roles("ADMIN").and()
	            .withUser("user").password("user").roles("USER");
	    }

	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	     /*   http.csrf().disable().
	             authorizeRequests().antMatchers("/login","/","/home").permitAll()
	            .antMatchers("/student/list","/student/showFormForAdd","/student/showFormForUpdate/**").hasRole("ADMIN")
	            .antMatchers("/student/list").hasRole("USER").and()
	            .formLogin();*/
	    	
	    	http.csrf().disable().
            authorizeRequests().antMatchers("/login","/","/home").permitAll()
           .antMatchers("/student/list","/student/showFormForAdd","/student/showFormForUpdate/**").permitAll();
           
	        http.headers().frameOptions().disable();
	    }

}
