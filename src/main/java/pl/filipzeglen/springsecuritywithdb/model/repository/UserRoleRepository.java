package pl.filipzeglen.springsecuritywithdb.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.filipzeglen.springsecuritywithdb.model.account.Role;

@Repository
public interface UserRoleRepository extends CrudRepository<Role, Long> {
}
