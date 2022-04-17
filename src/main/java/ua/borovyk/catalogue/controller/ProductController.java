package ua.borovyk.catalogue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ua.borovyk.catalogue.dto.ProductFullInfoDto;
import ua.borovyk.catalogue.dto.ProductShortInfoDto;
import ua.borovyk.catalogue.service.ProductImageService;
import ua.borovyk.catalogue.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    private final ProductImageService productImageService;

    @Autowired
    public ProductController(ProductService productService, ProductImageService productImageService) {
        this.productService = productService;
        this.productImageService = productImageService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProductShortInfoDto>> getAllProducts(@RequestParam("sortField") String field,
                                                                    @RequestParam("sortDirection") String direction,
                                                                    @RequestParam(value = "fragment", required = false) String fragment,
                                                                    @RequestParam(value = "typeId", required = false) Long typeId) {
        List<ProductShortInfoDto> products;
        var sort = Sort.by(Direction.fromString(direction), field);
        if (typeId != null && fragment != null) {
            products = productService.getAllProductsByFragmentAndType(fragment, typeId, sort);
        } else if (fragment != null) {
            products = productService.getAllProductsByFragment(fragment, sort);
        } else if (typeId != null) {
            products = productService.getAllProductsByType(typeId, sort);
        } else {
            products = productService.getAllProducts(sort);
        }
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductFullInfoDto> getProduct(@PathVariable("id") Long id) {
        return ResponseEntity.ok(productService.getProduct(id));
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveProduct(@ModelAttribute ProductFullInfoDto productDto,
                                         @RequestPart(value = "productImage", required = false) MultipartFile productImage) {
        var product = productService.saveProduct(productDto);
        if (productImage != null) {
            productImageService.saveProductImage(product, productImage);
        }
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }
}
