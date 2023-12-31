package br.com.jonasdev.controller.teste;

import br.com.jonasdev.infra.config.exceptions.NotFoundException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RequiredArgsConstructor
@RestController
@RequestMapping("/")
public class ProductApiController {

    private final ProductService productService;

    @GetMapping(value = "/products")
    public ResponseEntity<List<ProductValue>> getProducts() {
        List<ProductValue> productValues = productService.getProducts();
        return new ResponseEntity<>(productValues, HttpStatus.OK);
    }

    @GetMapping(value = "/products/{productId}")
    public ResponseEntity<ProductValue> getProduct(@PathVariable("productId") long productId) {
        try {
            ProductValue branch = productService.getProduct(productId);
            return new ResponseEntity<>(branch, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            throw new NotFoundException(e.getMessage());
        }
    }

    @PostMapping(value = "/products")
    public ResponseEntity<ProductValue> createProduct(@Valid @RequestBody ProductValue productValue) {
        ProductValue product = productService.createProduct(productValue);
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add(HttpHeaders.LOCATION, "/products/" + product.getProductId());
        return new ResponseEntity<>(product, headers, HttpStatus.CREATED);
    }

    @PutMapping(value = "/products/{productId}")
    ResponseEntity<ProductValue> updateProduct(@PathVariable long productId, @Valid @RequestBody ProductValue productValue) {
        productValue.setProductId(productId);
        try {
            ProductValue product = productService.updateProduct(productValue);
            return new ResponseEntity<>(product, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            throw new NotFoundException(e.getMessage());
        }
    }

    @DeleteMapping("/products/{productId}")
    ResponseEntity<Void> deleteProduct(@PathVariable long productId) {
        try {
            productService.deleteProductById(productId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (EntityNotFoundException e) {
            throw new NotFoundException(e.getMessage());
        }
    }

    @GetMapping(value = "/async/products")
    public CompletableFuture<ResponseEntity<List<ProductValue>>> asyncGetProducts() {
        List<ProductValue> productValues = productService.getProducts();
        return CompletableFuture.completedFuture(new ResponseEntity<>(productValues, HttpStatus.OK));
    }

    @GetMapping(value = "/async/products/{productId}")
    public CompletableFuture<ResponseEntity<ProductValue>> asyncGetProduct(@PathVariable("productId") long productId) {
        return CompletableFuture.completedFuture(getProduct(productId));
    }

}
