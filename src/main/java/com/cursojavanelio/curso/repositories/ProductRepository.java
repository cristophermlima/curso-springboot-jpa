package com.cursojavanelio.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursojavanelio.curso.entities.Category;
import com.cursojavanelio.curso.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
