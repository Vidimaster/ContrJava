package org.example;

//Итератор для первоначальной версии

import java.util.*;

public class ToyList<Toy> implements Iterable<Toy>{

    private PriorityQueue<Toy> bList;

    public ToyList(int i, ToyComparator toyComparator) {
        this.bList = new PriorityQueue<Toy>(i, (Comparator<? super Toy>) toyComparator);

    }
    @Override
    public Iterator<Toy> iterator() {

        return bList.iterator();
    }
    public void put(Toy t) {
        bList.add(t);
    }


}
