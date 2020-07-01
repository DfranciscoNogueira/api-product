package br.com.alt.f4.tecnologia.config;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.alt.f4.tecnologia.entity.Product;
import br.com.alt.f4.tecnologia.repositorys.ProductRepository;

@Component
public class DataLoader {

	private ProductRepository productRepository;

	@Autowired
	public DataLoader(ProductRepository productRepository) {
		this.productRepository = productRepository;
		loadProducts();
	}
	
	private void loadProducts() {
		this.productRepository.deleteAll();
		this.productRepository.save(new Product("Pia", "Pia De Cozinha com as melhores ofertas", BigDecimal.valueOf(30.50)));
		this.productRepository.save(new Product("Tomada", "com duas entradas", BigDecimal.valueOf(8.99)));
		this.productRepository.save(new Product("Chuveiro", "Chuveiro eletrico", BigDecimal.valueOf(66.4)));
		this.productRepository.save(new Product("Haste Aterramento", "Aterramento revestida de Cobre 5/8x2400mm", BigDecimal.valueOf(90.52)));
		this.productRepository.save(new Product("Torneiro com filtro", "Torneira para pia da cozinha", BigDecimal.valueOf(38.98)));
		this.productRepository.save(new Product("Caibro", "Caibros, Quadrados e Pontaletes", BigDecimal.valueOf(99.00)));
    }

}