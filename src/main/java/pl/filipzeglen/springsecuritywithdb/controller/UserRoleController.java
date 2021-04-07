package pl.filipzeglen.springsecuritywithdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.filipzeglen.springsecuritywithdb.model.account.Role;
import pl.filipzeglen.springsecuritywithdb.service.UserRoleService;

import java.util.Optional;

@RestController
@RequestMapping("/roles")
public class UserRoleController {

    private UserRoleService userRoleService;

    @Autowired
    public UserRoleController(UserRoleService userRoleService) { this.userRoleService = userRoleService; }

    @GetMapping("/all")
    public Iterable<Role> getAllRoles() {
        return userRoleService.findAll();
    }

    @GetMapping
    public Optional<Role> getRoleById(@RequestParam Long index) {
        return userRoleService.findById(index);
    }

    @PostMapping
    public Role addRole(@RequestBody Role userRole) {
        return userRoleService.save(userRole);
    }

    @PutMapping
    public Role updateRole(@RequestBody Role userRole) {
        return userRoleService.save(userRole);
    }

    @DeleteMapping
    public void deleteRole(@RequestParam Long index) { userRoleService.deleteById(index); }
}
