package com.diegolimadeoliveira.catalogo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diegolimadeoliveira.catalogo.entities.Order;
import com.diegolimadeoliveira.catalogo.services.OrderService;

@RestController //pra falar que a classe é um recurso web, implementado por um controlador rest
@RequestMapping(value = "/orders")
public class OrderResource {
	
	@Autowired //para o spring fazer a infecao de dependencia
	private OrderService service;
	
	@GetMapping
	public ResponseEntity<List<Order>> findAll(){

		//instanciacao manual mocada que foi feita inicialmente
		//Order u = new Order(1L, "Maria", "maria@gmail.com", "99999999", "123456");
		//return ResponseEntity.ok().body(u);
		
		List<Order> list = service.findAll(); 
		return ResponseEntity.ok().body(list);
	}
	
	//endPoint
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id){
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
