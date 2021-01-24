package se.black_lemon;

import se.black_lemon.data.StringArrayData;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Del_1 {

    public static void main(String[] args) {
        // Using Arrays.stream() to convert
        // array into Stream
        Stream<String > stream = Arrays.stream(StringArrayData.austin);

        //1- Hur många ord med fler än 8 bokstäver innhåller texten?
        int numberOfWords = (int) stream.filter(word -> word.toCharArray().length> 8).count();
        System.out.println("Ord antal med fler än 8 bokstäver i arrayn:" + numberOfWords);



        //2- Hur många unika ord innehåller texten?
        long uniqueWordCount = Arrays.stream(StringArrayData.austin)
                .map(String::toLowerCase)
                // Build a map from word -> frequency
                .collect(Collectors.groupingBy(w -> w, Collectors.counting()))
                // stream the frequency map entries
                .entrySet().stream()
                // filter to retain unique words (with frequency == 1)
                .filter(e -> e.getValue() == 1)
                // count them
                .count();
        //prompt out the value.
        System.out.println("texten innehåller " + uniqueWordCount + " unika ord.");

        //3- hur många ord med färre än 4 tecken?
        numberOfWords = (int) Arrays.stream(StringArrayData.austin).filter(word -> word.toCharArray().length< 4).count();
        System.out.println("Ord antal med färre än 4 bokstäver i arrayn: " + numberOfWords);



        //4- Hur många unika ord med fler än 8 bokstäver?
        uniqueWordCount = Arrays.stream(StringArrayData.austin)
                .filter(word -> word.toCharArray().length > 8 )
                .map(String::toLowerCase)
                // Build a map from word -> frequency
                .collect(Collectors.groupingBy(w -> w, Collectors.counting()))
                // stream the frequency map entries
                .entrySet().stream()
                // filter to retain unique words (with frequency == 1)
                .filter(e -> e.getValue() == 1)
                // count them
                .count();
        System.out.println("Unika Ord antal med fler än 8 bokstäver i arrayn: " + uniqueWordCount);


        //5- Vilken är den genomsnittliga ordlängden?
        int averageLength = Arrays.stream(StringArrayData.austin).mapToInt(String::length).sum() / StringArrayData.austin.length;
        System.out.println("Den genomsnittliga ordlängden: " + averageLength);

        //6- Det totala antalet tecken i listan (dvs summan av längden av alla ingående strängar)?
        int totalChars = Arrays.stream(StringArrayData.austin).mapToInt(String::length).sum();
        System.out.println("Det totala antalet tecken i listan: " + totalChars);

    }
}
