package ua.borovyk.catalogue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.borovyk.catalogue.data.entity.Type;
import ua.borovyk.catalogue.service.TypeService;

import java.util.List;

@RestController
@RequestMapping("/type")
public class CategoryController {

    private final TypeService typeService;

    @Autowired
    public CategoryController(TypeService typeService) {
        this.typeService = typeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Type>> getAllCategories() {
        var categories = typeService.getAllTypes();
        return ResponseEntity.ok(categories);
    }
}
