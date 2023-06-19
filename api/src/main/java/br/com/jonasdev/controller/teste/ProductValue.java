package br.com.jonasdev.controller.teste;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import br.com.jonasdev.domain.Product;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductValue {

    @JsonProperty("productId")
    private Long productId;

    @NotNull
    @Size(max = 255)
    @JsonProperty("name")
    private String name;

    public static ProductValue fromEntity(Product product) {
        return ProductValue.builder()
                .productId(product.getId())
                .name(product.getName())
                .build();
    }

//    public static Product fromValue(ProductValue product) {
//        return Product.builder()
//                .id(product.getProductId())
//                .name(product.getName())
//                .build();
//    }

}
