package com.luisribeiro.CursoSpring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.luisribeiro.CursoSpring.entities.User;
import com.luisribeiro.CursoSpring.repositories.UserRepository;

@Component
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
		
	}

	public void salvar(User usuario) {
		repository.save(usuario);
		
	}
	

}
