package com.br.fontana.digital.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		
		httpSecurity.csrf().disable().authorizeRequests()
			 // allow anonymous resource requests
		        .antMatchers(
		                HttpMethod.GET,		                
		                "/",
		                "/v2/api-docs",           // swagger
		                "/webjars/**",            // swagger-ui webjars
		                "/swagger-resources/**",  // swagger-ui resources
		                "/configuration/**",      // swagger configuration
		                "/*.html",
		                "/favicon.ico",
		                "/**/*.html",
		                "/**/*.css",
		                "/**/*.js",
		                "/auth/**"
		        ).permitAll();
       
		//		.antMatchers(HttpMethod.POST, "/login").permitAll().anyRequest().authenticated().and()

				// filtra requisições de login
		//		.addFilterBefore(new JWTLoginFilter("/login", authenticationManager()),	UsernamePasswordAuthenticationFilter.class)

				// filtra outras requisições para verificar a presença do JWT no
				// header
		//		.addFilterBefore(new JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
		//auth.inMemoryAuthentication().withUser("Vinicius").password("123456").roles("ADMIN");
	}
	
	
}
