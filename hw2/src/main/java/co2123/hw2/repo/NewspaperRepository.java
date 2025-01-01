package co2123.hw2.repo;

import co2123.hw2.model.Journalist;
import co2123.hw2.model.Newspaper;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NewspaperRepository extends CrudRepository<Newspaper, Integer> {
    List<Newspaper> findByName(String name);

    List<Newspaper> findByBossSpeciality(String speciality);
}
