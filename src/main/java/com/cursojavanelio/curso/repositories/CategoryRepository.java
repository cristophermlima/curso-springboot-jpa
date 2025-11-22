package com.cursojavanelio.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursojavanelio.curso.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
