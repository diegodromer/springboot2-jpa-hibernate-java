package com.diegolimadeoliveira.catalogo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diegolimadeoliveira.catalogo.entities.Category;
import com.diegolimadeoliveira.catalogo.services.CategoryService;

@RestController //pra falar que a classe é um recurso web, implementado por um controlador rest
@RequestMapping(value = "/categories")
public class CategoryResource {
	
	@Autowired //para o spring fazer a infecao de dependencia
	private CategoryService service;
	
	@GetMapping
	public ResponseEntity<List<Category>> findAll(){

		//instanciacao manual mocada que foi feita inicialmente
		//Category u = new Category(1L, "Maria", "maria@gmail.com", "99999999", "123456");
		//return ResponseEntity.ok().body(u);
		
		List<Category> list = service.findAll(); 
		return ResponseEntity.ok().body(list);
	}
	
	//endPoint
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id){
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
