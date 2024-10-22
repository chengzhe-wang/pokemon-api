package fr.efrei.pokemon.dto;

import java.util.List;

public class UpdateBag {
    private int capacity;

    private String trainer;

    private List<String> pockets;

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

    public List<String> getPockets() {
        return pockets;
    }

    public void setPockets(List<String> pockets) {
        this.pockets = pockets;
    }
}
