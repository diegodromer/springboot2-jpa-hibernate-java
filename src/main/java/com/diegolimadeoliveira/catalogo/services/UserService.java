package com.diegolimadeoliveira.catalogo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegolimadeoliveira.catalogo.entities.User;
import com.diegolimadeoliveira.catalogo.repositories.UserRepository;


@Service
public class UserService {
	
	@Autowired
	private UserRepository repository; //depenpencia para UserRepositoria para fazer busca
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id){
		repository.deleteById(id);
	}
	
	public User update(Long id, User obj) {
		User entity = repository.getOne(id); //nao vai no banco de dados ainda, vai so deixar um objeto monitorado pelo JPA - é melhor que findById
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());	
	}
	
}
