package mg.project.miniprojet.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import mg.project.miniprojet.security.JwtAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtFilter;
    public SecurityConfig(JwtAuthenticationFilter jwtFilter) {
        this.jwtFilter = jwtFilter;
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
       http
           .csrf(AbstractHttpConfigurer::disable)
           .httpBasic(AbstractHttpConfigurer::disable)
           .formLogin(AbstractHttpConfigurer::disable)
           .sessionManagement(session ->
               session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
           )
           .authorizeHttpRequests(auth -> auth
               .requestMatchers("/api/auth/**").permitAll()
               .requestMatchers("/h2/**").permitAll()
               .requestMatchers("/swagger-ui/**").permitAll()
               .requestMatchers("/swagger-ui.html").permitAll()
               .requestMatchers("/v3/api-docs/**").permitAll()
               .requestMatchers("/error").permitAll()
               .anyRequest().authenticated()
           )
           .headers(headers -> headers.frameOptions(frame -> frame.disable()))
           .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);


       return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager();
    }
}