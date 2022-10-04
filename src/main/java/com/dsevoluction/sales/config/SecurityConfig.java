package com.dsevoluction.sales.config;

import com.dsevoluction.sales.services.impl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // $2a$12$RhNFLGPVxpGEKadrRkg9dednVNx1xZJxKzi8ST/ZHNuQy6rfYMRvi
    // $2a$12$jXDPAhQgQcT6eSJTkYz66ug532F99hW1blhgA6lOHmXXw82lokdvm

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); //gera diferentes hashs para a mesma senha e de forma automatica aumentando a segurança do app.
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.userDetailsService(usuarioService)
               .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/clientes/**")
                    .hasRole("USER")
                .antMatchers("products/**")
                    .hasAnyRole("USER", "ADMIN")
                .antMatchers("/orders/**")
                    .hasRole("USER")
                .antMatchers(HttpMethod.POST,"/users/**")
                    .permitAll()
                .and()
                    .httpBasic();
    }
}
