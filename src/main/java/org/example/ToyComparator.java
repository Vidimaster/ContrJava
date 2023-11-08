package org.example;

//Компаратор для сортировки по полям объектов

import java.util.Comparator;

public class ToyComparator implements Comparator<Toy> {

    public int compare(Toy s1, Toy s2) {
        if (s1.chance < s2.chance)
            return 1;
        else if (s1.chance > s2.chance)
            return -1;
        return 0;
    }
}
