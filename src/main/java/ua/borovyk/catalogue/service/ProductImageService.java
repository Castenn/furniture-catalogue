package ua.borovyk.catalogue.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.borovyk.catalogue.data.entity.ProductImage;
import ua.borovyk.catalogue.data.repository.ProductImageRepository;

import java.util.List;

@Service
public class ProductImageService {

    private final ProductImageRepository productImageRepository;

    @Autowired
    public ProductImageService(ProductImageRepository productImageRepository) {
        this.productImageRepository = productImageRepository;
    }

    public List<ProductImage> getImagesByProductId(Long productId) {
        return productImageRepository.findAllByProductId(productId);
    }
}
