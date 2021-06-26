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
	
	public void delete(Long id) {
		
		repository.deleteById(id);
		
	}
	
	public User update(Long id, User obj) {
		User entity =  repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
	}
private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		
	}

//
//	public void salvar(User usuario) {
//		repository.save(usuario);
//		
//	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}

}
