package com.sixdelta.exposp;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.security.Principal;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;


@SpringBootApplication
@EnableOAuth2Sso
@RestController

public class ExpospApplication extends WebSecurityConfigurerAdapter{

	@RequestMapping("/user")
  public Principal user(Principal principal) {
    return principal;
  }
	
	@Bean
	@ConfigurationProperties("Google")
	public ClientResources Google() {
	  return new ClientResources();
	}


	@Override
  protected void configure(HttpSecurity http) throws Exception {
    http
      .antMatcher("/**")
      .authorizeRequests()
        .antMatchers("/**","/cliente**", "/cuenta**", "/alta**","/cuentas**","/webjars/**")     
        .permitAll()
      .anyRequest()
        .authenticated();
    
    http.csrf().disable();
  }

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(ExpospApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
	}
}
