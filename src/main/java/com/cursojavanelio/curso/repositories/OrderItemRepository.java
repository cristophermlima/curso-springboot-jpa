package com.cursojavanelio.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursojavanelio.curso.entities.OrderItem;
import com.cursojavanelio.curso.entities.pk.OrderItemPK;


public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {
	
}
