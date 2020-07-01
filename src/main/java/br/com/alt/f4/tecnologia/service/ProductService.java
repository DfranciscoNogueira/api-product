package br.com.alt.f4.tecnologia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alt.f4.tecnologia.entity.Product;
import br.com.alt.f4.tecnologia.repositorys.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public Optional<Product> findById(Long id) {
		return this.productRepository.findById(id);
	}

	public List<Product> findAll() {
		return this.productRepository.findAll();
	}

	public Product save(Product product) {
		return this.productRepository.save(product);
	}

	public void deleteById(long id) {
		this.productRepository.deleteById(id);
	}

	public void deleteAll() {
		this.productRepository.deleteAll();
	}

}