package com.luisribeiro.CursoSpring.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luisribeiro.CursoSpring.entities.Category;
import com.luisribeiro.CursoSpring.service.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
	@Autowired
	private CategoryService service;

	@GetMapping
	public ResponseEntity<List> findeAll() {
		List<Category> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id) {
		Category obj = service.findById(id);
		return ResponseEntity.ok(obj);
	}

	@PostMapping(value = "/")
	public ResponseEntity<Void> criarUsuario(
			@RequestBody Category usuario){
		
		
	service.salvar(usuario);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}


