package ua.borovyk.catalogue.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ua.borovyk.catalogue.data.entity.Product;
import ua.borovyk.catalogue.data.repository.ProductRepository;
import ua.borovyk.catalogue.dto.ProductFullInfoDto;
import ua.borovyk.catalogue.dto.ProductImageDto;
import ua.borovyk.catalogue.dto.ProductShortInfoDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    private final TypeService typeService;

    private final ProductImageService productImageService;

    @Autowired
    public ProductService(ProductRepository productRepository,
                          TypeService typeService,
                          ProductImageService productImageService) {
        this.productRepository = productRepository;
        this.typeService = typeService;
        this.productImageService = productImageService;
    }

    public List<ProductShortInfoDto> getAllProducts(Sort sort) {
        return productRepository.findAll(sort)
                .stream()
                .map(this::composeShortInfoDto)
                .collect(Collectors.toList());
    }

    public List<ProductShortInfoDto> getAllProductsByType(Long typeId, Sort sort) {
        var type = typeService.getTypeById(typeId);
        return productRepository.findAllByTypeAndSort(type, sort)
                .stream()
                .map(this::composeShortInfoDto)
                .collect(Collectors.toList());
    }

    public List<ProductShortInfoDto> getAllProductsByFragment(String fragment, Sort sort) {
        return getAllProducts(sort)
                .stream()
                .filter(product -> product.getName().toLowerCase().contains(fragment.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<ProductShortInfoDto> getAllProductsByFragmentAndType(String fragment, Long typeId, Sort sort) {
        return getAllProductsByType(typeId, sort)
                .stream()
                .filter(product ->product.getName().toLowerCase().contains(fragment.toLowerCase()))
                .collect(Collectors.toList());
    }

    public ProductFullInfoDto getProduct(Long id) {
        var product = productRepository.findById(id).orElseThrow();
        return composeFullInfoDto(product);
    }

    public Product saveProduct(ProductFullInfoDto productFullInfoDto) {
        var product = ProductFullInfoDto.toProduct(productFullInfoDto);
        var type = typeService.getTypeById(productFullInfoDto.getTypeId());
        product.setType(type);

        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productImageService.deleteProductImages(productRepository.findById(id).orElseThrow());
        productRepository.deleteById(id);
    }

    private ProductShortInfoDto composeShortInfoDto(Product product) {
        var productImage = productImageService.getProductImage(product);
        var productShortInfoDto = ProductShortInfoDto.fromProduct(product);

        productShortInfoDto.setImage(ProductImageDto.fromProductImage(productImage));
        return productShortInfoDto;
    }

    private ProductFullInfoDto composeFullInfoDto(Product product) {
        var productImage = productImageService.getProductImage(product);
        var productFullInfoDto = ProductFullInfoDto.fromProduct(product);

        productFullInfoDto.setImage(ProductImageDto.fromProductImage(productImage));
        return productFullInfoDto;
    }

}
