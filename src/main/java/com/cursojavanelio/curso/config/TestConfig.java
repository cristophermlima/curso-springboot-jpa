package com.cursojavanelio.curso.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.cursojavanelio.curso.entities.Category;
import com.cursojavanelio.curso.entities.Order;
import com.cursojavanelio.curso.entities.OrderItem;
import com.cursojavanelio.curso.entities.Product;
import com.cursojavanelio.curso.entities.User;
import com.cursojavanelio.curso.entities.enums.OrderStatus;
import com.cursojavanelio.curso.repositories.CategoryRepository;
import com.cursojavanelio.curso.repositories.OrderItemRepository;
import com.cursojavanelio.curso.repositories.OrderRepository;
import com.cursojavanelio.curso.repositories.ProductRepository;
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
	
	@Autowired
	private ProductRepository productRepository;

	@Autowired 
	private OrderItemRepository orderItemRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Eletronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		Product p1 = new Product(null, "prod1", "descrption prod1", 100.0, "");
		Product p2 = new Product(null, "prod2", "description prod2", 101.0, "");
		Product p3 = new Product(null, "prod3", "descripition prod3", 102.0, "");
		
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3)); // isso salva no banco de dados 
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3));

		p1.getCategories().add(cat2); // associação entre os objetos produto e categoria
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p1.getCategories().add(cat2);
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3));
		
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
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p2, 3, p2.getPrice());
		
		orderItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3));
	}
}
