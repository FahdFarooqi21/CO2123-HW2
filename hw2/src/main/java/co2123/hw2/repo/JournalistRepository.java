package co2123.hw2.repo;

import co2123.hw2.model.Journalist;
import org.springframework.data.repository.CrudRepository;

public interface JournalistRepository extends CrudRepository<Journalist, String> {
}
