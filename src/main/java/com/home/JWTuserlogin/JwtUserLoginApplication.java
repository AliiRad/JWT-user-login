package com.home.JWTuserlogin;

import com.home.JWTuserlogin.model.entity.Role;
import com.home.JWTuserlogin.model.entity.User;
import com.home.JWTuserlogin.model.repository.RoleRepository;
import com.home.JWTuserlogin.model.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
@RequiredArgsConstructor
public class JwtUserLoginApplication {

	private final UserRepository userRepository;
	private final RoleRepository roleRepository;
	private final PasswordEncoder passwordEncoder;


	@Bean
	public void run(){

		roleRepository.save(Role.builder()
				.authority("USER")
				.build());

		Set<Role> adminRole = new HashSet<>();
		adminRole.add(new Role("ADMIN"));

		User admin = User.builder()
				.username("admin")
				.password("admin123")
				.authorities(adminRole)
				.build();

		userRepository.save(admin);
	}

	public static void main(String[] args) {
		SpringApplication.run(JwtUserLoginApplication.class, args);
	}
	

}
