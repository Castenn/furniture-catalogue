package ua.borovyk.catalogue.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.borovyk.catalogue.data.entity.Type;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TypeDto {

    public static TypeDto fromType(Type type) {
        var typeDto = new TypeDto();
        typeDto.setId(type.getId());
        typeDto.setName(type.getName());
        return typeDto;
    }

    private Long id;

    private String name;

}
