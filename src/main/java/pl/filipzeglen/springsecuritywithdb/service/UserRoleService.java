package pl.filipzeglen.springsecuritywithdb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.filipzeglen.springsecuritywithdb.model.account.UserRole;
import pl.filipzeglen.springsecuritywithdb.model.repository.UserRoleRepository;

import java.util.Optional;

@Service
public class UserRoleService {

    private UserRoleRepository userRoleRepository;

    @Autowired
    public UserRoleService(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    public Optional<UserRole> findById(Long id) {
        return userRoleRepository.findById(id);
    }

    public Iterable<UserRole> findAll() {
        return userRoleRepository.findAll();
    }

    public UserRole save(UserRole userRole) {
        return userRoleRepository.save(userRole);
    }

    public void deleteById(Long id) {
        userRoleRepository.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB() {
//        save(new UserRole("ROLE_ADMINISTRATOR", "Administrator of SoftBastion"));
//        save(new UserRole("ROLE_USER", "User of SoftBastion"));
//        save(new UserRole("ROLE_STUDENT", "Student of SoftBastion"));
//        save(new UserRole("ROLE_MODERATOR", "Moderator of SoftBastion"));
    }
}
