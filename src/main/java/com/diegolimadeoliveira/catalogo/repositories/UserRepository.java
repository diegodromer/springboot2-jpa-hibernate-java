package com.diegolimadeoliveira.catalogo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diegolimadeoliveira.catalogo.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
}
