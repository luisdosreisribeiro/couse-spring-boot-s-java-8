package com.luisribeiro.CursoSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luisribeiro.CursoSpring.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
