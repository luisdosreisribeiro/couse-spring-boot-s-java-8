package com.luisribeiro.CursoSpring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.luisribeiro.CursoSpring.entities.Category;
import com.luisribeiro.CursoSpring.repositories.CategoryRepository;

@Component
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	public List<Category> findAll(){
		return repository.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get();
		
	}

	public void salvar(Category usuario) {
		repository.save(usuario);
		
	}
	

}
