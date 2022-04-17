package ua.borovyk.catalogue.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.borovyk.catalogue.data.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

    boolean existsAdminByLoginAndPassword(String login, String password);

}
