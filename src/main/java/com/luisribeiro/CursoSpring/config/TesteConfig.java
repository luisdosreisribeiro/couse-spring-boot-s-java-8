package com.luisribeiro.CursoSpring.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.luisribeiro.CursoSpring.entities.Category;
import com.luisribeiro.CursoSpring.entities.Order;
import com.luisribeiro.CursoSpring.entities.OrderItem;
import com.luisribeiro.CursoSpring.entities.Product;
import com.luisribeiro.CursoSpring.entities.User;
import com.luisribeiro.CursoSpring.entities.enums.OrderStatus;
import com.luisribeiro.CursoSpring.repositories.CategoryRepository;
import com.luisribeiro.CursoSpring.repositories.OrderItemRepository;
import com.luisribeiro.CursoSpring.repositories.OrderRepository;
import com.luisribeiro.CursoSpring.repositories.ProductRepository;
import com.luisribeiro.CursoSpring.repositories.UserRepository;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner{
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(0, "Electonic");
		Category cat2 = new Category(0, "Book");
		Category cat3 = new Category(0, "Computers");
		

		
		Product p1 = new Product(0,"The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(0, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(0, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(0, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(0, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, ""); 
		
		
		
		
	
		categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));		
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);
		
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		
		Order o1 = new Order(null, Instant.parse("2019-06-20t19:53:07Z"),OrderStatus.PAID,u1);
		Order o2 = new Order(null, Instant.parse("2019-07-20t19:53:07Z"),OrderStatus.WAITTING_PAYMENT,u1);
		Order o3 = new Order(null, Instant.parse("2019-08-20t19:53:07Z"),OrderStatus.WAITTING_PAYMENT,u1);
		
		userRepository.saveAll(Arrays.asList(u1,u2));
		orderRepository.saveAll(Arrays.asList(o1, o2,o3));
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice()); 
		
		orderItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4 ));
		
	}

}
