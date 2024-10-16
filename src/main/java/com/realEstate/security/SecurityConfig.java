//package com.realEstate.security;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//
//        System.out.println("security .......");
//        // Disabling CSRF protection for this example (consider enabling in production with session-based authentication)
//        http.csrf(csrf -> csrf.disable())
//
//                // Authorization configuration: Protecting admin and user endpoints
//                .authorizeHttpRequests(authz -> authz
//                        .requestMatchers("/admin").hasRole("ADMIN")   // Only ADMIN role can access /admin
//                        .requestMatchers("/user").hasRole("USER")// Only USER role can access /user
//                        .anyRequest().permitAll()                    // Allow all other requests without authentication
//                )
//
//                // Enabling HTTP Basic authentication
//                .httpBasic(basic -> basic
//                        .realmName("MyApp")                         // Optionally set a realm name
//                );
//
//        return http.build();                                // Build and return the security configuration
//    }
//}

package com.realEstate.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        System.out.println("Security disabled...");

        // Disable all security features
        http.csrf(csrf -> csrf.disable())  // Disable CSRF protection
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll()   // Allow all requests without any authentication or authorization
                )
                .securityContext(securityContext -> securityContext.disable()) // Disable the security context
                .sessionManagement(session -> session.disable());  // Disable session management

        return http.build();  // Build and return the security configuration
    }
}

