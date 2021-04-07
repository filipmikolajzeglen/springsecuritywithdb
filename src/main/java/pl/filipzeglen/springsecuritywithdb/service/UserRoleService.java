package pl.filipzeglen.springsecuritywithdb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.filipzeglen.springsecuritywithdb.model.account.Role;
import pl.filipzeglen.springsecuritywithdb.model.repository.UserRoleRepository;

import java.util.Optional;

@Service
public class UserRoleService {

    private UserRoleRepository userRoleRepository;

    @Autowired
    public UserRoleService(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    public Optional<Role> findById(Long id) {
        return userRoleRepository.findById(id);
    }

    public Iterable<Role> findAll() {
        return userRoleRepository.findAll();
    }

    public Role save(Role userRole) {
        return userRoleRepository.save(userRole);
    }

    public void deleteById(Long id) {
        userRoleRepository.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB() {
        save(new Role("ROLE_ADMINISTRATOR", "Administrator of SoftBastion"));
        save(new Role("ROLE_USER", "User of SoftBastion"));
        save(new Role("ROLE_STUDENT", "Student of SoftBastion"));
        save(new Role("ROLE_MODERATOR", "Moderator of SoftBastion"));
    }
}
