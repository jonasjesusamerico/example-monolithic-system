package br.com.jonasdev.controller.teste;

import br.com.jonasdev.domain.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {

}