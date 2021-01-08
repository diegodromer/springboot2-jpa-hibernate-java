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
}
