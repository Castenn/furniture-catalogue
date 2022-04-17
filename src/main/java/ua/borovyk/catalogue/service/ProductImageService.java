package ua.borovyk.catalogue.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ua.borovyk.catalogue.data.entity.Product;
import ua.borovyk.catalogue.data.entity.ProductImage;
import ua.borovyk.catalogue.data.repository.ProductImageRepository;
import ua.borovyk.catalogue.util.ImageDataUtil;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

@Service
public class ProductImageService {

    private final ProductImageRepository productImageRepository;

    @Autowired
    public ProductImageService(ProductImageRepository productImageRepository) {
        this.productImageRepository = productImageRepository;
    }

    public ProductImage getProductImage(Product product) {
        return productImageRepository.findByProduct(product).orElse(new ProductImage());
    }

    public ProductImage saveProductImage(Product product, MultipartFile image) {
        var name = UUID.randomUUID().toString();
        var originalFilename = image.getOriginalFilename();
        Objects.requireNonNull(originalFilename);
        var extension = originalFilename.substring(originalFilename.lastIndexOf('.') + 1);
        var content = new byte[0];
        try {
            content = image.getBytes();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        deleteProductImages(product);
        ImageDataUtil.saveProductImage(name, extension, content);

        var productImage = new ProductImage();
        productImage.setProduct(product);
        productImage.setPath(ImageDataUtil.PRODUCT_IMAGE_PATH);
        productImage.setName(name);
        productImage.setExtension(extension);
        productImage.setOrderIndex(0);
        return productImageRepository.save(productImage);
    }

    public void deleteProductImages(Product product) {
        var productImages = productImageRepository.findAllByProduct(product);
        productImages.forEach(productImage -> {
            ImageDataUtil.deleteProductImage(productImage.getName(), productImage.getExtension());
            productImageRepository.delete(productImage);
        });
    }
}
