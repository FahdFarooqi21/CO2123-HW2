package co2123.hw2;

import co2123.hw2.model.Article;
import co2123.hw2.model.Journalist;
import co2123.hw2.model.Newspaper;
import co2123.hw2.repo.ArticleRepository;
import co2123.hw2.repo.JournalistRepository;
import co2123.hw2.repo.NewspaperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class Hw2Application implements CommandLineRunner {

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private JournalistRepository journalistRepository;
    @Autowired
    private NewspaperRepository newspaperRepository;

    public static void main(String[] args) {
        SpringApplication.run(Hw2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Newspaper newspaper1 = new Newspaper();
        newspaper1.setId(1);
        newspaper1.setName("Newspaper 1");
        newspaper1 = newspaperRepository.save(newspaper1);

        Newspaper newspaper2 = new Newspaper();
        newspaper2.setId(2);
        newspaper2.setName("Newspaper 2");
        newspaper2 = newspaperRepository.save(newspaper2);

        Article article1 = new Article();
        article1.setIdentifier(1);
        article1.setVisits(69);
        article1 = articleRepository.save(article1);

        Article article2 = new Article();
        article2.setIdentifier(2);
        article2.setVisits(20);
        article2 = articleRepository.save(article2);

        Journalist journalist1 = new Journalist();
        journalist1.setArticles(new ArrayList<>());
        journalist1.getArticles().add(article1);
        journalist1.setNewspapers(new ArrayList<>());
        journalist1.getNewspapers().add(newspaper1);
        journalist1.setSpeciality("Sports");
        journalist1.setPopular(article1);
        journalist1 = journalistRepository.save(journalist1);

        Journalist journalist2 = new Journalist();
        journalist2.setArticles(new ArrayList<>());
        journalist2.getArticles().add(article2);
        journalist2.setNewspapers(new ArrayList<>());
        journalist2.getNewspapers().add(newspaper2);
        journalist2.setSpeciality("Celebrity");
        journalist2.setPopular(article2);
        journalist2 = journalistRepository.save(journalist2);

        newspaper1.setBoss(journalist1);
        newspaper2.setBoss(journalist2);
        newspaper1.setJournalists(new ArrayList<>());
        newspaper1.getJournalists().add(journalist1);
        newspaper2.setJournalists(new ArrayList<>());
        newspaper2.getJournalists().add(journalist2);
        newspaper1 = newspaperRepository.save(newspaper1);
        newspaper2 = newspaperRepository.save(newspaper2);

    }
}
