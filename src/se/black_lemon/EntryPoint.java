package se.black_lemon;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class EntryPoint {

    public static void main(String[] args) {

        System.out.println("Del 1 :\n**************************");
        Del_1 del_1 = new Del_1();
        System.out.println("********************************\n");
        System.out.println("Del 2:\n***************************");
        Del_2 del_2 = new Del_2();
        System.out.println("********************************\n");


        //MyObj stuff:
        MyObject[] hundredsObj = generate100Obj();
        //1. Skapa en Array som bara innehåller objekt vars value överstiger 20.

        calcAverage(hundredsObj);

        MyObject[]  Over20Values = arrOfValOver20(hundredsObj);
        changeNames(hundredsObj);
    }


    //fill the array
    private static MyObject[] generate100Obj() {
        MyObject[] objs = new MyObject[100];
        int random;
        for (int i = 0; i < 100; i++) {
            random = (int) (Math.random() * (101 - 1+1) + 1);
            boolean randomBool = new Random().nextBoolean();
            objs[i] = new MyObject(randomBool, random, "name" + i);
        }
        return objs;
    }


    //3. Byta namnet till this is trueför alla objekt vars boolean är true.
    private static void changeNames(MyObject[] fiftyRandom) {
        List<MyObject> listObjs = Arrays.asList(fiftyRandom);
        listObjs = listObjs
                .stream()
                .map(x -> {
                    if (!x.getBool()) {
                        x.setName("Another name than " + x.getName());
                    }
                    return x;
                })
                .collect(Collectors.toList());

        listObjs.forEach(obj -> {
            System.out.println(obj.toString());
        });
    }

    //2. Beräkna medelvärdet av alla values
    private static void calcAverage(MyObject[] hundredRandom) {
        List<MyObject> listObjs = Arrays.asList(hundredRandom);
        double average = listObjs
                .stream()
                .mapToDouble(x -> x.getValue())
                .average()
                .getAsDouble();
        System.out.println("---------------------------------");
        System.out.println("Average of values is: " + average);
        System.out.println("---------------------------------");

    }

    private static MyObject[] arrOfValOver20(MyObject[] hundredRandom) {
        List<MyObject> listObjs = Arrays.asList(hundredRandom);
        List<MyObject> above20 = listObjs
                .stream()
                .filter(x -> x.getValue() > 20)
                .collect(Collectors.toList());

        System.out.println("---------- Array of objs with Values over 20 -----------");
        above20.forEach(obj -> {
            System.out.println(obj.toString());
        });

        System.out.println("------------------------------------------------------------------");


        MyObject[] array = new MyObject[above20.size()];
        above20.toArray(array);
        return array;
    }



}
