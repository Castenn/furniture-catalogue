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
public class ProductFullInfoDto {

    private Long id;

    private Integer article;

    private String name;

    private ProductImageDto image;

    private String description;

    private Integer price;

    private Double height;

    private Double width;

    private Double depth;

    private Long typeId;

    public static ProductFullInfoDto fromProduct(Product product) {
        return new ProductFullInfoDto(
                product.getId(),
                product.getArticle(),
                product.getName(),
                null,
                product.getDescription(),
                product.getPrice(),
                product.getHeight(),
                product.getWidth(),
                product.getDepth(),
                product.getType().getId()
        );
    }

    public static Product toProduct(ProductFullInfoDto productFullInfoDto) {
        return new Product(
                productFullInfoDto.getId(),
                productFullInfoDto.getArticle(),
                productFullInfoDto.getName(),
                productFullInfoDto.getDescription(),
                productFullInfoDto.getPrice(),
                productFullInfoDto.getHeight(),
                productFullInfoDto.getWidth(),
                productFullInfoDto.getDepth(),
                null
        );
    }

}
