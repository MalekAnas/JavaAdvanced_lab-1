package se.black_lemon;

import se.black_lemon.data.DoubleArrayData;

import java.util.*;
import java.util.stream.Collectors;


public class Del_2 {

    public Del_2(){

        System.out.println("Hur många av talen är större än 1000? " + nONumbersAbov1K());
        System.out.println("2. använd map, filter och distinct för att skapa en doublearray som in-nehåller alla tal som är\n" +
                "mindre än 1000 och har en heltalsdel som ärjämnt delbara med tre." + Arrays.toString(lessThan1KDivisibleTo3()));
        System.out.println("3. Vilken är summan av alla tal i arrayen under 500?" + sumLessThan500());
        System.out.println("4. Medelvärdet för alla tal mellan 2000 och 3000? " + averageBetween2k_3k());
        System.out.println("5. Vilket är det Största värdet respektiva minsta värdet i arrayen? " + Arrays.toString(largestAndSmallest()));
    }

    //1. Hur många av talen är större än 1000?
    private int nONumbersAbov1K(){
        return  ((int) Arrays.stream(DoubleArrayData.doubleArray).filter(n -> n >1000).count());
    }


    //2. använd map, filter och distinct för att skapa en doublearray som in-nehåller alla tal som är
    // mindre än 1000 och har en heltalsdel som ärjämnt delbara med tre.
    private double[] lessThan1KDivisibleTo3(){
        double[] resultArr = Arrays.stream(DoubleArrayData.doubleArray).filter(n -> n < 1000 ).distinct().filter(n -> {
            return ((n >= 0 ? Math.floor(n) : Math.ceil(n)) % 3==0);
        }).toArray();
        return resultArr;
    }

    //3. Vilken är summan av alla tal i arrayen under 500?
    private double sumLessThan500(){
        double count = Arrays.stream(DoubleArrayData.doubleArray).filter(n -> n < 500).sum();
        return count;
    }


    //4. Medelvärdet för alla tal mellan 2000 och 3000?
    private double averageBetween2k_3k(){
        double average = Arrays.stream(DoubleArrayData.doubleArray).filter(n -> (n >2000 && n < 3000)).average().getAsDouble();
        return average;
    }

    //5. Vilket är det Största värdet respektiva minsta värdet i arrayen?
    private double[] largestAndSmallest(){

        double smallest = Arrays.stream(DoubleArrayData.doubleArray).min().getAsDouble();
        double largest = Arrays.stream(DoubleArrayData.doubleArray).max().getAsDouble();
        double[] bounds = {smallest , largest};
        return bounds;
    }

}
