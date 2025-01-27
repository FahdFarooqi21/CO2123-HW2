package co2123.hw2.model;

import jakarta.persistence.*;

@Entity

public class Article {

    @Id
    @GeneratedValue
    private int identifier;
    private int visits;

    public int getIdentifier() {
        return identifier;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    public int getVisits() {
        return visits;
    }

    public void setVisits(int visits) {
        this.visits = visits;
    }

    @Override
    public String toString() {
        return "Article{" +
                "identifier=" + identifier +
                ", visits=" + visits +
                '}';
    }
}
