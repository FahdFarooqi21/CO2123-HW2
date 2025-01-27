package co2123.hw2.controller;

import co2123.hw2.model.Article;
import co2123.hw2.model.Journalist;
import co2123.hw2.model.Newspaper;
import co2123.hw2.repo.ArticleRepository;
import co2123.hw2.repo.JournalistRepository;
import co2123.hw2.repo.NewspaperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DeleteController {
    @Autowired
    private NewspaperRepository newspaperRepository;
    @Autowired
    private JournalistRepository journalistRepository;
    @Autowired
    private ArticleRepository articleRepository;

    @RequestMapping("/deleteNewspaper")
    public String deleteNewspaper(@RequestParam int id) {
        if (newspaperRepository.findById(id).isPresent()) {
            newspaperRepository.delete(newspaperRepository.findById(id).get());
        }
        return "redirect:/";
    }

    @RequestMapping("/deleteJournalist")
    public String deleteJournalist(@RequestParam String speciality) {
        if (journalistRepository.findById(speciality).isPresent()) { //Finds journalist with given speciality
            Journalist journalist = journalistRepository.findById(speciality).get(); //Sets variable Journalist to deleted journalist

            for (Newspaper newspaper : journalist.getNewspapers()) { // Removes references of the journalist from list of journalists in newspaper
                newspaper.getJournalists().remove(journalist);
                newspaperRepository.save(newspaper);

                if(newspaper.getBoss()==null){break;}

                if (newspaper.getBoss().getSpeciality().equals(speciality)) { // If removed journalist is Boss, sets Boss to null
                    newspaper.setBoss(null);
                    newspaperRepository.save(newspaper);
                }

            }

            journalistRepository.delete(journalist); // Deletes journalist from repository after all references of journalist are removed

        }
        return "redirect:/";
    }

    @RequestMapping("/deleteArticle")
    public String deleteArticle(@RequestParam int identifier) {
        if (articleRepository.findById(identifier).isPresent()) { //Finds article to be deleted
            Article article = articleRepository.findById(identifier).get(); // sets variable article to article we need to delete

            for(Journalist journalist : journalistRepository.findAll()){// Remove references of article in list of articles in journalist
                if (journalist.getArticles().isEmpty()){continue;}
                for (Article journalistarticle : journalist.getArticles()){
                    if(journalistarticle.getIdentifier() == identifier){
                        journalist.getArticles().remove(journalistarticle);
                        journalistRepository.save(journalist);
                        break;

                    }
                }
                if(journalist.getPopular() == null){break;}
                if (journalist.getPopular().getIdentifier() == identifier) {
                    journalist.setPopular(null);
                    journalistRepository.save(journalist);
                }

            }

            articleRepository.delete(article);
        }
        return "redirect:/";
    }
}
