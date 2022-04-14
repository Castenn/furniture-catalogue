package ua.borovyk.catalogue.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.borovyk.catalogue.data.entity.Type;

@Repository
public interface TypeRepository extends JpaRepository<Type, Long> {
}
