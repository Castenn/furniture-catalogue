package ua.borovyk.catalogue.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductFullIndoDto {

    private Long id;

    private Integer article;

    private String name;

    private String description;

    private Integer price;

    private Double height;

    private Double width;

    private Double deep;

    private Long typeId;

}
