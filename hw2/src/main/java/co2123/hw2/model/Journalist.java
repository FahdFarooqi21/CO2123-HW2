package co2123.hw2.model;

import jakarta.persistence.*;

import java.util.List;

import static jakarta.persistence.FetchType.EAGER;

@Entity
public class Journalist {
    @Id
    private String speciality;
    @ManyToMany(mappedBy = "journalists")
    private List<Newspaper> newspapers;
    @OneToMany(cascade = CascadeType.REMOVE, fetch=EAGER)
    @JoinColumn
    private List <Article> articles;
    @OneToOne
    private Article popular;

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public List<Newspaper> getNewspapers() {
        return newspapers;
    }

    public void setNewspapers(List<Newspaper> newspapers) {
        this.newspapers = newspapers;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public Article getPopular() {
        return popular;
    }

    public void setPopular(Article popular) {
        this.popular = popular;
    }

    @Override
    public String toString() {
        return "Journalist{" +
                "popular=" + popular +
                ", articles=" + articles +
                ", speciality='" + speciality + '\'' +
                '}';
    }
}
