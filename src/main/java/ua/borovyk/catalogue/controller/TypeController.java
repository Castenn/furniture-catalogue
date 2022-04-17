package ua.borovyk.catalogue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.borovyk.catalogue.dto.TypeDto;
import ua.borovyk.catalogue.service.TypeService;

import java.util.List;

@RestController
@RequestMapping("/api/type")
public class TypeController {

    private final TypeService typeService;

    @Autowired
    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<TypeDto>> getAllTypes() {
        var categories = typeService.getAllTypeDtos();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeDto> getTypeById(@PathVariable("id") Long id) {
        var category = typeService.getTypeDtoById(id);
        return ResponseEntity.ok(category);
    }
}
