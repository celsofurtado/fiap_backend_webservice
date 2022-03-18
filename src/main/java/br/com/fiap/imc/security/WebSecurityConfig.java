package br.com.fiap.imc.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationService authenticationService;

    // Responsável pela configuração de autenticação
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(authenticationService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }

    // Responsável pela autorização. Quem pode acessar uma determinada URL
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/api/users").permitAll()
                .antMatchers(HttpMethod.GET, "/api/users").hasAnyRole("ADMIN", "USER")
                .antMatchers(HttpMethod.GET, "/api/users/*").hasAnyRole("ADMIN", "USER")
                .antMatchers(HttpMethod.GET, "/api/histories").hasAnyRole("ADMIN", "USER")
                .antMatchers(HttpMethod.DELETE, "/api/histories").hasAnyRole("ADMIN", "USER")
                .antMatchers(HttpMethod.PUT, "/api/users/*").hasAnyRole("ADMIN", "USER")
                .anyRequest().authenticated()
                .and().httpBasic()
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    // Responsável pela configuração de recursos estáticos
    @Override
    public void configure(WebSecurity web) throws Exception {
        //web.ignoring().antMatchers("/materialize/**", "/style/**");
    }

}
