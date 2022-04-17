package ua.borovyk.catalogue.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.borovyk.catalogue.data.entity.ProductImage;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductImageDto {

    private Long id;

    private String path;

    private String name;

    private String extension;

    private Long productId;

    public static ProductImageDto fromProductImage(ProductImage productImage) {
        return new ProductImageDto(
                productImage.getId(),
                productImage.getPath(),
                productImage.getName(),
                productImage.getExtension(),
                productImage.getProduct() != null ? productImage.getProduct().getId() : null
        );
    }

}
