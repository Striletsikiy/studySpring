package biatarus.studySpring.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/dentist/**").hasRole("DENTIST")
                        .requestMatchers("/patient/**").hasRole("PATIENT")
                        .requestMatchers("/register","/login","/").permitAll()
                        .anyRequest().permitAll()
                )
                .formLogin(form -> form
                .loginPage("/login")  // Шлях до вашої сторінки логіна
                .defaultSuccessUrl("/home", true)  // Куди перенаправляти після успішного логіна
                .permitAll()
        )
                .logout(logout -> logout
                        .logoutSuccessUrl("/login?logout")  // Після логауту
                        .permitAll());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
