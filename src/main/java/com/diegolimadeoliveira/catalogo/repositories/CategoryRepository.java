package com.diegolimadeoliveira.catalogo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diegolimadeoliveira.catalogo.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
	
}
