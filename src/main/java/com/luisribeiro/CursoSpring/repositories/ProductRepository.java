package com.luisribeiro.CursoSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luisribeiro.CursoSpring.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
