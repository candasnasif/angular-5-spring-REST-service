package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	@Autowired
    CustomUserDetailsService userDetailsService;
     
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	    auth.userDetailsService(userDetailsService);

	}
     
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    
    	http.csrf().disable();
      http.authorizeRequests()
        .antMatchers("/", "/home,/home/newCustomer,/home/newOwner,/register").permitAll()
        .antMatchers("/OwnerPage/**").access("hasRole('owner')")
        .antMatchers("/CustomerPage/**").access("hasRole('ROLE_customer')")
        .antMatchers("/UpdateInformation").access("hasRole('ROLE_customer')")
        .and().formLogin()
        .loginProcessingUrl("/home")
        .loginPage("/home")
        .defaultSuccessUrl("/home")
        .usernameParameter("user_username").passwordParameter("user_password")
        .and().exceptionHandling().accessDeniedPage("/Access_Denied");
    }
}
