package ua.borovyk.catalogue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.borovyk.catalogue.data.entity.Admin;
import ua.borovyk.catalogue.service.AuthorizationService;

@RestController
@RequestMapping("/api/authorization")
public class AdminController {

    private final AuthorizationService authorizationService;

    @Autowired
    public AdminController(AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Admin admin) {
        if (authorizationService.adminExists(admin.getLogin(), admin.getPassword())) {
            return ResponseEntity.ok(admin);
        }
        return ResponseEntity.badRequest().build();
    }

}
