package com.luisribeiro.CursoSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luisribeiro.CursoSpring.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
