package br.com.alt.f4.tecnologia.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alt.f4.tecnologia.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}