package fr.efrei.pokemon.models;

import jakarta.persistence.*;

import java.util.List;


@Entity
public class Bag {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @OneToMany
    private List<Pocket> pocket;

    @OneToOne
    private Trainer trainer;

    private int capacity;

    public List<Pocket> getPocket() {
        return pocket;
    }

    public void setPocket(List<Pocket> pocket) {
        this.pocket = pocket;
    }


    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
