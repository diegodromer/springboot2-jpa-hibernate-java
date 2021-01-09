package com.diegolimadeoliveira.catalogo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegolimadeoliveira.catalogo.entities.Order;
import com.diegolimadeoliveira.catalogo.repositories.OrderRepository;


@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository; //depenpencia para OrderRepositoria para fazer busca
	
	public List<Order> findAll(){
		return repository.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}
}
