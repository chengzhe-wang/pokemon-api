package fr.efrei.pokemon.dto;

import java.util.List;

public class CreateBag {

    private int capacity;

    private String trainer;

    private List<String> pocket;

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getTrainer() {
        return trainer;
    }

    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }

    public List<String> getPocket() {
        return pocket;
    }

    public void setPocket(List<String> pocket) {
        this.pocket = pocket;
    }
}
