package ua.borovyk.catalogue.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.borovyk.catalogue.data.entity.ProductImage;

import java.util.List;

@Repository
public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM product_image WHERE product_id = ?1")
    List<ProductImage> findAllByProductId(Long productId);
}
