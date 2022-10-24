package sahachan.prac.ttoproj.config;


import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.firewall.DefaultHttpFirewall;
import org.springframework.security.web.firewall.HttpFirewall;
import sahachan.prac.ttoproj.security.controller.JwtAuthenticationEntryPoint;
import sahachan.prac.ttoproj.security.controller.JwtAuthenticationTokenFilter;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@Slf4j
public class WebSecurityConfig {
    final JwtAuthenticationEntryPoint unauthorizedHandler;
    final JwtAuthenticationTokenFilter tokenFilter;

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .cors().and()
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests()
                .antMatchers("/auth/**","/register").permitAll()
//                .antMatchers(HttpMethod.GET,"/credential","/refresh").hasAnyRole("USER","PATIENT","DOCTOR","ADMIN")
                .antMatchers(HttpMethod.GET,"/credential","/refresh").permitAll()
//                .antMatchers(HttpMethod.POST,"/admin/verify/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST,"/admin/**").permitAll()
                .antMatchers(HttpMethod.GET,"/admin/**").permitAll()
                .antMatchers(HttpMethod.POST,"/doctor/**").permitAll()
                .antMatchers(HttpMethod.GET,"/doctor/**").permitAll()
                .antMatchers(HttpMethod.GET,"/patient/**").permitAll()
                .anyRequest()
                .authenticated();
        http
                .addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);

        http.headers().frameOptions().disable();
        // disable page caching
        http.headers().cacheControl();
        log.info("SecurityFilterChain created");
        return http.build();
    }

//    @Bean
//    ServerHttpSecurity serverHttpSecurity() {
//        return ServerHttpSecurity.http();
//    }

    @SneakyThrows
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)  {
        return authenticationConfiguration.getAuthenticationManager();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtAuthenticationTokenFilter authenticationTokenFilterBean() throws Exception {
        return new JwtAuthenticationTokenFilter();
    }

    @Bean
    public WebSecurityCustomizer configure() {
        return (web) -> web.httpFirewall(allowUrlEncodedSlashHttpFirewall());
    }

    @Bean
    public HttpFirewall allowUrlEncodedSlashHttpFirewall() {
        DefaultHttpFirewall firewall = new DefaultHttpFirewall();
        firewall.setAllowUrlEncodedSlash(true);
        return firewall;
    }


}