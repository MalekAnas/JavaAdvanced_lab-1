package se.black_lemon;

import java.util.Arrays;
import java.util.List;
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
        MyObject[] arrValOver20 = arrOfValOver20(hundredsObj);

        calcAverage(hundredsObj);
        changeNames(hundredsObj);
    }


    //fill the array
    private static MyObject[] generate100Obj() {
        MyObject[] objs = new MyObject[1000];
        int random;
        for (int i = 0; i < 50; i++) {
            random = ThreadLocalRandom.current().nextInt(0, 1000 + 1);
            objs[i] = new MyObject((Math.random() < 0.5), random, "name" + i);
        }
        return objs;
    }


    //3. Byta namnet till this is trueför alla objekt vars boolean är true.
    private static void changeNames(MyObject[] fiftyRandom) {
        List<MyObject> listObjs = Arrays.asList(fiftyRandom);
        listObjs = listObjs
                .stream()
                .map(x -> {
                    if (x.getBool()) {
                        x.setName("this is true");
                    }
                    return x;
                })
                .collect(Collectors.toList());

        listObjs.forEach(obj -> {
            System.out.println(obj.toString());
        });
    }

    //2. Beräkna medelvärdet av alla values
    private static void calcAverage(MyObject[] fiftyRandom) {
        List<MyObject> listObjs = Arrays.asList(fiftyRandom);
        double average = listObjs
                .stream()
                .mapToDouble(x -> x.getValue())
                .average()
                .getAsDouble();
        System.out.println("Average of values is: " + average);
    }

    private static MyObject[] arrOfValOver20(MyObject[] fiftyRandom) {
        List<MyObject> listObjs = Arrays.asList(fiftyRandom);
        List<MyObject> above20 = listObjs
                .stream()
                .filter(x -> x.getValue() > 20)
                .collect(Collectors.toList());

        above20.forEach(obj -> {
            System.out.println(obj.toString());
        });

        MyObject[] array = new MyObject[above20.size()];
        above20.toArray(array);
        return array;
    }



}
