package br.com.alt.f4.tecnologia.controllers;

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

import br.com.alt.f4.tecnologia.entity.Product;
import br.com.alt.f4.tecnologia.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping
	public List<Product> findAll() {
		return this.productService.findAll();
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		return this.productService.findById(id).map(record -> ResponseEntity.ok().body(record)).orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<Product> create(@RequestBody Product product) {
		Product obj = this.productService.save(product);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Product> update(@PathVariable("id") long id, @RequestBody Product product) {
		return this.productService.findById(id).map(record -> {
			
			record.setId(product.getId());
			record.setName(product.getName());
			record.setValue(product.getValue());
			record.setDescription(product.getDescription());
			Product updated = this.productService.save(record);
			return ResponseEntity.accepted().body(updated);
			
		}).orElse(ResponseEntity.notFound().build());
		
	}

	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity<?> delete(@PathVariable long id) {
		return this.productService.findById(id).map(record -> {
			this.productService.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}

}