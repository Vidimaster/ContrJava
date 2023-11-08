package org.example;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        Random ran = new Random();

        // В три массива записываются игрушки с разным весом

        List<Toy> ToyArray1 = new ArrayList<Toy>();
        ToyArray1.add(new Toy(1, 20, "Конструктор"));
        ToyArray1.add(new Toy(2, 20, "Робот"));
        ToyArray1.add(new Toy(3, 60, "Кукла"));

        List<Toy> ToyArray2 = new ArrayList<Toy>();
        ToyArray2.add(new Toy(1, 30, "Конструктор2"));
        ToyArray2.add(new Toy(2, 30, "Робот2"));
        ToyArray2.add(new Toy(3, 40, "Кукла2"));

        List<Toy> ToyArray3 = new ArrayList<Toy>();
        ToyArray3.add(new Toy(1, 40, "Конструктор3"));
        ToyArray3.add(new Toy(2, 40, "Робот3"));
        ToyArray3.add(new Toy(3, 10, "Кукла3"));
        ToyArray3.add(new Toy(4, 10, "Кукла4"));

        // Игрушки тасуются перед дальнейшим случайным выбором

        Collections.shuffle(ToyArray1);
        Collections.shuffle(ToyArray2);
        Collections.shuffle(ToyArray3);

        //В приоритетные очереди случайно помещаются игрушки согласно весу, в таких очередях приоритет задаётся либо
        // весом через сортировку компаратором и случайным числом,
        // либо порядком помещения в очередь (при одинаковом весе),
        // поэтому они также тасуются перед каждым случайным выбором для перестановки игрушек с одинаковым весом

        PriorityQueue<Toy> pq1 = new PriorityQueue<Toy>(4, new ToyComparator());
        PriorityQueue<Toy> pq2 = new PriorityQueue<Toy>(3, new ToyComparator());
        PriorityQueue<Toy> pq3 = new PriorityQueue<Toy>(3, new ToyComparator());

        GetRandom(ToyArray1, ran.nextInt(1, 100), pq1);
        Collections.shuffle(ToyArray1);
        GetRandom(ToyArray1, ran.nextInt(1, 100), pq1);
        Collections.shuffle(ToyArray1);
        GetRandom(ToyArray1, ran.nextInt(1, 100), pq1);
        Collections.shuffle(ToyArray1);
        GetRandom(ToyArray1, ran.nextInt(1, 100), pq1);

        GetRandom(ToyArray2, ran.nextInt(1, 100), pq2);
        Collections.shuffle(ToyArray2);
        GetRandom(ToyArray2, ran.nextInt(1, 100), pq2);
        Collections.shuffle(ToyArray2);
        GetRandom(ToyArray2, ran.nextInt(1, 100), pq2);
        Collections.shuffle(ToyArray2);

        GetRandom(ToyArray3, ran.nextInt(1, 100), pq3);
        Collections.shuffle(ToyArray3);
        GetRandom(ToyArray3, ran.nextInt(1, 100), pq3);
        Collections.shuffle(ToyArray3);
        GetRandom(ToyArray3, ran.nextInt(1, 100), pq3);
        Collections.shuffle(ToyArray3);

        //Все игрушки помещаются в общую очередь из результирующих приоритетных очередей и записываются в файл

        Queue<String> queue = new LinkedList<String>();

        while (!pq1.isEmpty()) {
          queue.add(pq1.peek().toString());
          pq1.poll();
         }

        while (!pq2.isEmpty()) {
            queue.add(pq2.peek().toString());
            pq2.poll();
        }

        while (!pq3.isEmpty()) {
            queue.add(pq3.peek().toString());
            pq3.poll();
        }

        while (!queue.isEmpty()) {
            System.out.println(queue.peek().toString());
            WriteToFile(queue.peek().toString());

            queue.poll();
        }
        System.out.println("Очередь записана в файл queue.txt");
        WriteToFile("*****************");
    }

    static void GetRandom(List <Toy> Arrl, int nxt, PriorityQueue<Toy> pq) {
        boolean flag = false;
        Collections.sort(Arrl, new ToyComparator());
        for (Toy str : Arrl) {
                if (nxt >= str.chance) {
                    pq.add(str);
                    flag = true;
                    break;
            }
        }
        if (flag == false){
            Collections.sort(Arrl, new ToyComparator());
            pq.add(Arrl.get(0));
        }
    }

    public static void WriteToFile(String str)
            throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("queue.txt", true));
        writer.append("\n");
        writer.append(str);
        writer.close();
    }
}