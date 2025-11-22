package com.cursojavanelio.curso.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.cursojavanelio.curso.entities.Category;
import com.cursojavanelio.curso.entities.Order;
import com.cursojavanelio.curso.entities.User;
import com.cursojavanelio.curso.entities.enums.OrderStatus;
import com.cursojavanelio.curso.repositories.CategoryRepository;
import com.cursojavanelio.curso.repositories.OrderRepository;
import com.cursojavanelio.curso.repositories.UserRepository;

@Configuration 
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Eletronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3)); // isso salva no banco de dados 
		
		User u1 = new User(null, "maria b", "maria@gmail.com", "999999999", "123456");
		User u2 = new User(null, "joao c", "joão@gmail.com", "999999998", "123456");
		User u3 = new User(null, "luis d", "luis@gmail.com", "999999997", "123456");
		User u4 = new User(null, "pedro e", "pedro@gmail.com", "999999996", "123456");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID,u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.DELIVERED, u3);
		Order o4 = new Order(null, Instant.parse("2019-07-19T17:20:27Z"), OrderStatus.SHIPPED, u4);
		
		userRepository.saveAll(Arrays.asList(u1, u2, u3, u4));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3, o4));
	}
}
