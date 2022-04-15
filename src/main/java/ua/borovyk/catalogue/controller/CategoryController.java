package ua.borovyk.catalogue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.borovyk.catalogue.dto.TypeDto;
import ua.borovyk.catalogue.service.TypeService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/type")
public class CategoryController {

    private final TypeService typeService;

    @Autowired
    public CategoryController(TypeService typeService) {
        this.typeService = typeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<TypeDto>> getAllCategories() {
        var categories = typeService.getAllTypes().stream()
                .map(TypeDto::fromType)
                .collect(Collectors.toList());
        return ResponseEntity.ok(categories);
    }
}
