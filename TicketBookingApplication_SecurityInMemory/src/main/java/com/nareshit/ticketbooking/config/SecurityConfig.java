/**
 * 
 */
package com.nareshit.ticketbooking.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author hp
 *
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	
	// below method is for authentication purpose
	@Autowired
	public void configure_global(AuthenticationManagerBuilder authenticationObj) throws Exception {
		
		authenticationObj.inMemoryAuthentication().withUser("nareshitadmin").password("{noop}nareshitadmin").roles("ADMIN");
		authenticationObj.inMemoryAuthentication().withUser("nareshitguest").password("{noop}nareshitguest").roles("GUEST");
		
	}
	
	
	// below method is for authorization purpose
	
	//ADMIN can acess all tickets and GUEST can access only few ticktes
	
	@Override
	public void configure(HttpSecurity authorizationObj ) throws Exception{
		
		authorizationObj.csrf().disable().authorizeRequests().antMatchers("/tickets/all/**").hasAnyRole("ADMIN").and().formLogin();
		authorizationObj.csrf().disable().authorizeRequests().antMatchers("/tickets/ticket/**").hasAnyRole("ADMIN","GUEST").and().formLogin();
	}
		
}
