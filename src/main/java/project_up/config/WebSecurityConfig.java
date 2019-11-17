package project_up.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.sql.DataSource;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

//    @Autowired
//    private AccessDeniedHandler accessDeniedHandler;

    // роль admin всегда есть доступ к /admin/**
    // роль user всегда есть доступ к /user/**
    // Наш кастомный "403 access denied" обработчик

    @Autowired
    private DataSource dataSource;


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeRequests()
                    .antMatchers("/", "/home", "/registration").permitAll()
                    .anyRequest().authenticated()
                .and()
                    .formLogin()
                    .loginPage("/login")
                    .permitAll()
                .and()
                    .logout()
                    .permitAll()
                .and();
//                .exceptionHandling().accessDeniedHandler(accessDeniedHandler);
    }

//     создаем пользоватлелей, admin и user
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//
//        auth.inMemoryAuthentication()
//                .withUser("1").password("{noop}1").roles("USER")
//                .and()
//                .withUser("2").password("{noop}2").roles("ADMIN");
//    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(NoOpPasswordEncoder.getInstance())
                .usersByUsernameQuery("select username, password, active from usr where username=?")
                .authoritiesByUsernameQuery("select u.username, ur.roles from usr u inner join user_role ur on u.id = ur.user_id where u.username=?");


    }


}
