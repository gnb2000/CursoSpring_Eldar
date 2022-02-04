package com.controlClientes.ControlClientes.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(AuthenticationManagerBuilder build) throws Exception {
        build.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    /*@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //Guardar usuarios en memoria
        //AUTENTICACION
        auth.inMemoryAuthentication()
                .withUser("admin")
                    .password("{noop}123") //Clave no cifrada
                    .roles("ADMIN","USER")
                .and()
                .withUser("user")
                    .password("{noop}123")
                    .roles("USER");
    }*/

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //Restringir las url de la app
        //AUTORIZACION
        http.authorizeRequests()
                .antMatchers("/editar/**","/agregar/**","/eliminar")
                    .hasRole("ADMIN")
                .antMatchers("/personas","/")
                    .hasAnyRole("ADMIN","USER")
                .and()
                    .formLogin()
                    .loginPage("/login") //Es el html de login
                .and()
                .exceptionHandling().accessDeniedPage("/errores/403")
        ;

    }

}
