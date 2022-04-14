package ua.borovyk.catalogue.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.borovyk.catalogue.data.entity.Type;
import ua.borovyk.catalogue.data.repository.TypeRepository;

import java.util.List;

@Service
public class TypeService {

    private final TypeRepository typeRepository;

    @Autowired
    public TypeService(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    public List<Type> getAllTypes() {
        return typeRepository.findAll();
    }
}
