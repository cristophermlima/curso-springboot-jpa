package com.cursojavanelio.curso.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.cursojavanelio.curso.entities.User;
import com.cursojavanelio.curso.repositories.UserRepository;

@Configuration 
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "maria b", "maria@gmail.com", "999999999", "123456");
		User u2 = new User(null, "joao c", "joão@gmail.com", "999999998", "123456");
		User u3 = new User(null, "luis d", "luis@gmail.com", "999999997", "123456");
		User u4 = new User(null, "pedro e", "pedro@gmail.com", "999999996", "123456");
		
		userRepository.saveAll(Arrays.asList(u1, u2, u3, u4));
	}
}
