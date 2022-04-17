package ua.borovyk.catalogue.data.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.borovyk.catalogue.data.entity.Product;
import ua.borovyk.catalogue.data.entity.Type;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE p.type = ?1")
    List<Product> findAllByTypeAndSort(Type type, Sort sort);
}
