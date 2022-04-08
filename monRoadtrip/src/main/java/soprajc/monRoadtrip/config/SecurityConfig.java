package soprajc.monRoadtrip.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// @formatter:off
		http.antMatcher("/api/**")
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.csrf().disable()
				.authorizeHttpRequests()
					.antMatchers(HttpMethod.POST, "/api/compte/inscription").permitAll()
					.antMatchers("/api/compte/**").authenticated()
					.antMatchers("/api/participant/**").hasRole("CLIENT")
					.antMatchers("/api/reservation/**").hasRole("CLIENT")
					.antMatchers("/api/roadtrip/**").hasRole("CLIENT")
					.antMatchers("/api/etape/**").hasRole("CLIENT")
					.antMatchers("/api/logement/**").hasRole("HOTE")
					.antMatchers("/api/activite/**").hasRole("ORGANISATEUR")
					.anyRequest().denyAll()
					.and()
					.httpBasic();
		// @formatter:on

	}

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
