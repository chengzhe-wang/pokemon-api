package fr.efrei.pokemon.models;

import jakarta.persistence.*;

@Entity
public class Pocket {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    private int capacity;

//    @ManyToOne
//    @JoinColumn(name = "bag_id")
//    private Bag bag;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Bag getBag() {
//        return bag;
//    }
//
//    public void setBag(Bag bag) {
//        this.bag = bag;
//    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
