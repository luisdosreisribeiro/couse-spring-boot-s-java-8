package com.luisribeiro.CursoSpring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.luisribeiro.CursoSpring.entities.Product;
import com.luisribeiro.CursoSpring.repositories.ProductRepository;

@Component
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	public List<Product> findAll(){
		return repository.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get();
		
	}

	public void salvar(Product usuario) {
		repository.save(usuario);
		
	}
	

}
