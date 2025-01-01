package co2123.hw2.controller;

import co2123.hw2.repo.ArticleRepository;
import co2123.hw2.repo.JournalistRepository;
import co2123.hw2.repo.NewspaperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ListController {
    @Autowired
    private NewspaperRepository newspaperRepository;
    @Autowired
    private JournalistRepository journalistRepository;
    @Autowired
    private ArticleRepository articleRepository;

    @RequestMapping("/listNewspaper")
    public String listNewspaper(Model model) {
        model.addAttribute("data", newspaperRepository.findAll());
        model.addAttribute("title", "Newspapers");
        return "list";
    }

    @RequestMapping("/listJournalist")
    public String listJournalist(Model model) {
        model.addAttribute("data", journalistRepository.findAll());
        model.addAttribute("title", "Journalists");
        return "list";
    }

    @RequestMapping("/listArticle")
    public String listArticle(Model model) {
        model.addAttribute("data", articleRepository.findAll());
        model.addAttribute("title", "Articles");
        return "list";
    }
}
