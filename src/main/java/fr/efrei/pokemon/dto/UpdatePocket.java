package fr.efrei.pokemon.dto;

public class UpdatePocket {

    private String name;

//    private String bag;

    private int capacity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public String getBag() {
//        return bag;
//    }
//
//    public void setBag(String bag) {
//        this.bag = bag;
//    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
