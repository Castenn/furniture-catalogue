package ua.borovyk.catalogue.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.borovyk.catalogue.data.repository.AdminRepository;

@Service
public class AuthorizationService {

    private final AdminRepository adminRepository;

    @Autowired
    public AuthorizationService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public boolean adminExists(String login, String password) {
        return adminRepository.existsAdminByLoginAndPassword(login, password);
    }

}
