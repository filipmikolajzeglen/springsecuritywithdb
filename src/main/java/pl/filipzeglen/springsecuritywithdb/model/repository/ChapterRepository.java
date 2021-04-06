package pl.filipzeglen.springsecuritywithdb.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.filipzeglen.springsecuritywithdb.model.elearning.Chapter;

@Repository
public interface ChapterRepository extends CrudRepository<Chapter, Long> {
}
