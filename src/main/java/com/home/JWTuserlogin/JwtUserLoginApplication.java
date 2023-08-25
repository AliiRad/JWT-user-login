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

	public static void main(String[] args) {
		SpringApplication.run(JwtUserLoginApplication.class, args);
	}
	
	@Bean
	CommandLineRunner run(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder){
			return args -> {
				if (roleRepository.findByAuthority("ADMIN").isPresent()) return;
				Role adminRole = roleRepository.save(new Role("ADMIN"));
				roleRepository.save(new Role("USER"));

				Set<Role> role = new HashSet<>();
				role.add(adminRole);

				User admin = new User("admin", passwordEncoder.encode("admin123"), role);

				userRepository.save(admin);
			};
	}


}
