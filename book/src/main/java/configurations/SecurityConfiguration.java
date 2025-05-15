package configurations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.userdetails.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    	return http.csrf(customizer -> customizer.disable())
				.authorizeHttpRequests(req -> req.anyRequest().authenticated())
				//.formLogin(Customizer.withDefaults())
				.httpBasic(Customizer.withDefaults())
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.build();
    }
    @Bean
	public UserDetailsService userDetailsService() {
		UserDetails user1=User.withDefaultPasswordEncoder().username("abc").password("abc").roles("USER").build();
		UserDetails user2=User.withDefaultPasswordEncoder().username("def").password("def").roles("USER").build();
		UserDetails user3=User.withDefaultPasswordEncoder().username("ghi").password("ghi").roles("USER").build();
		//return new InMemoryUserDetailsManager(user1,user2,user3);
		
		List<UserDetails> users = new ArrayList<UserDetails>();
		users.add(user1);
		users.add(user2);
		users.add(user3);
		return new InMemoryUserDetailsManager(users);
		
	}
    
    @Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		 provider.setUserDetailsService(userDetailsService());
		return provider;
	}
}
