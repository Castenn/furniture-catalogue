package ua.borovyk.catalogue.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.borovyk.catalogue.data.entity.Type;
import ua.borovyk.catalogue.data.repository.TypeRepository;
import ua.borovyk.catalogue.dto.TypeDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TypeService {

    private final TypeRepository typeRepository;

    @Autowired
    public TypeService(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    public List<TypeDto> getAllTypeDtos() {
        return typeRepository.findAll()
                .stream()
                .map(TypeDto::fromType)
                .collect(Collectors.toList());
    }

    public TypeDto getTypeDtoById(Long id) {
        return TypeDto.fromType(getTypeById(id));
    }

    public Type getTypeById(Long id) {
        return typeRepository.findById(id).orElseThrow();
    }
}
