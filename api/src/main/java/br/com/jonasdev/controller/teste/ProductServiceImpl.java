package br.com.jonasdev.controller.teste;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import br.com.jonasdev.domain.Product;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Component
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    @Transactional(readOnly = true)
    public List<ProductValue> getProducts() {
        return StreamSupport.stream(productRepository.findAll().spliterator(), false)
                .map(ProductValue::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public ProductValue getProduct(long productId) {
        return productRepository.findById(productId)
                .map(ProductValue::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("Product " + productId + " not found"));
    }

    @Override
    @Transactional
    public ProductValue createProduct(ProductValue productValue) {
        Product product = Product.builder()
                .name(productValue.getName())
                .build();
        product = productRepository.save(product);
        return ProductValue.fromEntity(product);
    }

    @Override
    @Transactional
    public ProductValue updateProduct(ProductValue productValue) {
        Product product = productRepository.findById(productValue.getProductId())
                .orElseThrow(() -> new EntityNotFoundException("Product " + productValue.getProductId() + " not found"));
        product.setName(productValue.getName());
        return ProductValue.fromEntity(product);
    }

    @Override
    @Transactional
    public void deleteProductById(long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Product " + productId + " not found"));
        productRepository.delete(product);
    }
}
