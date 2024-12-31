package co2123.hw2.controller;

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
        if (journalistRepository.findById(speciality).isPresent()) {
            journalistRepository.delete(journalistRepository.findById(speciality).get());
        }
        return "redirect:/";
    }

    @RequestMapping("/deleteArticle")
    public String deleteArticle(@RequestParam int identifier) {
        if (articleRepository.findById(identifier).isPresent()) {
            articleRepository.delete(articleRepository.findById(identifier).get());
        }
        return "redirect:/";
    }
}
