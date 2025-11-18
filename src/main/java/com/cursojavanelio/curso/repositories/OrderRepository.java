package com.cursojavanelio.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursojavanelio.curso.entities.Order;



public interface OrderRepository extends JpaRepository<Order, Long> {
	
}
