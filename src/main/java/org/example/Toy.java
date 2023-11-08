package org.example;

public class Toy {

    int id;
    int chance;
    String name;

    public Toy(int id, int chance, String name) {
        this.id = id;
        this.chance = chance;
        this.name = name;
    }

    @Override
    public String toString() {
        return "{" +
                "chance=" + chance + "%" +
                ", name='" + name + '\'' +
                '}';
    }


}



