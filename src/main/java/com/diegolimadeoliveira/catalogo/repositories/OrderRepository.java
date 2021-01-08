package com.diegolimadeoliveira.catalogo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diegolimadeoliveira.catalogo.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
	
}
