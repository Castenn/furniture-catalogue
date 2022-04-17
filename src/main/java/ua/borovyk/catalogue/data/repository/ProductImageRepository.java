package ua.borovyk.catalogue.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.borovyk.catalogue.data.entity.Product;
import ua.borovyk.catalogue.data.entity.ProductImage;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {

    Optional<ProductImage> findByProduct(Product product);

    List<ProductImage> findAllByProduct(Product product);
}
