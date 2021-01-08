package com.diegolimadeoliveira.catalogo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diegolimadeoliveira.catalogo.entities.Product;
import com.diegolimadeoliveira.catalogo.services.ProductService;

@RestController //pra falar que a classe é um recurso web, implementado por um controlador rest
@RequestMapping(value = "/products")
public class ProductResource {
	
	@Autowired //para o spring fazer a infecao de dependencia
	private ProductService service;
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){

		//instanciacao manual mocada que foi feita inicialmente
		//Product u = new Product(1L, "Maria", "maria@gmail.com", "99999999", "123456");
		//return ResponseEntity.ok().body(u);
		
		List<Product> list = service.findAll(); 
		return ResponseEntity.ok().body(list);
	}
	
	//endPoint
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id){
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
