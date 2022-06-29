package com.example.backadmin.security.config;

import com.example.backadmin.security.jwt.JwtAuthenticationFilter;
import com.example.backadmin.security.jwt.JwtAutorisationFilter;
import com.example.backadmin.security.service.facade.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.authorizeRequests()


                //
//                .antMatchers(
//                        "/back-admin/v1/**",
//                        "/**",
//                        "/swagger-resources/**",
//                        "/swagger-ui.html",
//                        "/webjars/**",
//                        /*Probably not needed*/ "/swagger.json")
//                .permitAll()


                .antMatchers(HttpMethod.POST, "/v1/admin/user/sign-in/").permitAll()
                .antMatchers(HttpMethod.POST, "/v1/admin/user/").permitAll()
                .antMatchers("/v1/admin/service-demandeur/**").permitAll()
        //
                .antMatchers("/v1/admin/produit/**").permitAll()
                .antMatchers("/v1/admin/expression-besoin/**").permitAll()










//                .antMatchers("/api/v1/admin/**").hasAuthority("ROLE_ADMIN")
//                .antMatchers("/api/v1/admin/user/**").hasAuthority("ROLE_ADMIN")
                 .anyRequest().permitAll();
        // .anyRequest().authenticated();



        http.addFilter(new JwtAuthenticationFilter(authenticationManager()));
        http.addFilterBefore(jwtAutorisationFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private UserService userService;
    @Autowired
    private JwtAutorisationFilter jwtAutorisationFilter;

}
