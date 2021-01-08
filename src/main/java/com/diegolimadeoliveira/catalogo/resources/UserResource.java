package com.diegolimadeoliveira.catalogo.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.diegolimadeoliveira.catalogo.entities.User;
import com.diegolimadeoliveira.catalogo.services.UserService;

@RestController //pra falar que a classe é um recurso web, implementado por um controlador rest
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired //para o spring fazer a infecao de dependencia
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){

		//instanciacao manual mocada que foi feita inicialmente
		//User u = new User(1L, "Maria", "maria@gmail.com", "99999999", "123456");
		//return ResponseEntity.ok().body(u);
		
		List<User> list = service.findAll(); 
		return ResponseEntity.ok().body(list);
	}
	
	//endPoint
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping //201
	public ResponseEntity<User> insert(@RequestBody User obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}") //204
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
