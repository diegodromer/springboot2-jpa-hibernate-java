package com.diegolimadeoliveira.catalogo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diegolimadeoliveira.catalogo.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{
	
}
