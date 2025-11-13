package com.cursojavanelio.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursojavanelio.curso.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
}
