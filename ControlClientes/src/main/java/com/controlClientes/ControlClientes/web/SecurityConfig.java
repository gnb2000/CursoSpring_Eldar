package com.controlClientes.ControlClientes.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
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
    }

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
