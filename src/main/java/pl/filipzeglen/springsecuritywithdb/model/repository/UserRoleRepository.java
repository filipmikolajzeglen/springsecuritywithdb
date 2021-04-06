package pl.filipzeglen.springsecuritywithdb.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.filipzeglen.springsecuritywithdb.model.account.UserRole;

@Repository
public interface UserRoleRepository extends CrudRepository<UserRole, Long> {
}
