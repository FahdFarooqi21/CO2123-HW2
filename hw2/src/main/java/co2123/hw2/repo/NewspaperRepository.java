package co2123.hw2.repo;

import co2123.hw2.model.Newspaper;
import org.springframework.data.repository.CrudRepository;

public interface NewspaperRepository extends CrudRepository<Newspaper, Integer> {
}
