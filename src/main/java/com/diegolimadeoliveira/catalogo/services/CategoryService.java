package com.diegolimadeoliveira.catalogo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegolimadeoliveira.catalogo.entities.Category;
import com.diegolimadeoliveira.catalogo.repositories.CategoryRepository;


@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository; //depenpencia para CategoryRepositoria para fazer busca
	
	public List<Category> findAll(){
		return repository.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get();
	}
}
