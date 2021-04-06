package pl.filipzeglen.springsecuritywithdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.filipzeglen.springsecuritywithdb.model.account.UserRole;
import pl.filipzeglen.springsecuritywithdb.service.UserRoleService;

import java.util.Optional;

@RestController
@RequestMapping("/roles")
public class UserRoleController {

    private UserRoleService userRoleService;

    @Autowired
    public UserRoleController(UserRoleService userRoleService) { this.userRoleService = userRoleService; }

    @GetMapping("/all")
    public Iterable<UserRole> getAllRoles() {
        return userRoleService.findAll();
    }

    @GetMapping
    public Optional<UserRole> getRoleById(@RequestParam Long index) {
        return userRoleService.findById(index);
    }

    @PostMapping
    public UserRole addRole(@RequestBody UserRole userRole) {
        return userRoleService.save(userRole);
    }

    @PutMapping
    public UserRole updateRole(@RequestBody UserRole userRole) {
        return userRoleService.save(userRole);
    }

    @DeleteMapping
    public void deleteRole(@RequestParam Long index) { userRoleService.deleteById(index); }
}
