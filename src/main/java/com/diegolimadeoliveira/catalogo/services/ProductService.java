package com.diegolimadeoliveira.catalogo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegolimadeoliveira.catalogo.entities.Product;
import com.diegolimadeoliveira.catalogo.repositories.ProductRepository;


@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository; //depenpencia para ProductRepositoria para fazer busca
	
	public List<Product> findAll(){
		return repository.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get();
	}
}