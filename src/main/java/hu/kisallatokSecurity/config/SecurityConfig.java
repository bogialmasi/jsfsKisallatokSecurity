package hu.kisallatokSecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    public void configueAuth(AuthenticationManagerBuilder auth){
        try{
        auth.inMemoryAuthentication()
                .withUser("user").password("{noop}USER").roles("USER")
                .and()
                .withUser("admin").password("{noop}ADMIN").roles("ADMIN", "USER");}
        catch (Exception e) {
            System.out.println("EX in SecurityConfig.configureAuth: " + e.getMessage());
        }
    }

    @Override
    public void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/", "/pictures", "/pics/**").permitAll()
                .antMatchers("/admin").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .permitAll();
    }
}
