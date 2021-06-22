package com.luisribeiro.CursoSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luisribeiro.CursoSpring.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
