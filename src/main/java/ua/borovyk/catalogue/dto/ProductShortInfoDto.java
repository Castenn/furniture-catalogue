package ua.borovyk.catalogue.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

}
