package com.diegolimadeoliveira.catalogo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diegolimadeoliveira.catalogo.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
}
