package ua.borovyk.catalogue.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.borovyk.catalogue.data.entity.Product;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductShortInfoDto {

    private Long id;

    private String name;

    private ProductImageDto image;

    private Integer price;

    private Long typeId;

    public static ProductShortInfoDto fromProduct(Product product) {
        return new ProductShortInfoDto(
                product.getId(),
                product.getName(),
                null,
                product.getPrice(),
                product.getType().getId()
        );
    }

}
