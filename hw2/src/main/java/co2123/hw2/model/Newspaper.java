package co2123.hw2.model;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import javax.annotation.processing.Generated;
import java.util.List;

@Entity
public class Newspaper {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    @ManyToMany(cascade = CascadeType.PERSIST)
    private List <Journalist> journalists;
    @ManyToOne
    private Journalist boss;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Journalist> getJournalists() {
        return journalists;
    }

    public void setJournalists(List<Journalist> journalists) {
        this.journalists = journalists;
    }

    public Journalist getBoss() {
        return boss;
    }

    public void setBoss(Journalist boss) {
        this.boss = boss;
    }

    @Override
    public String toString() {
        return "Newspaper{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", journalists=" + journalists +
                ", boss=" + boss +
                '}';
    }
}
