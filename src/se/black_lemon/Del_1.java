package se.black_lemon;

import se.black_lemon.data.StringArrayData;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Del_1 {


    public Del_1(){
        //here goes prompting
        System.out.println("Ord antal med fler än 8 bokstäver i arrayn:" + nOWordsLongerThan8());
        System.out.println("texten innehåller " + nOUniqueWords() + " unika ord.");
        System.out.println("Ord antal med färre än 4 tecken " +  nOWordsShorterThan4());
        System.out.println("Unika Ord antal med fler än 8 bokstäver i arrayn: " + nOUniqueWordsLongerThan8());
        System.out.println("Den genomsnittliga ordlängden: " + averageWordLength());
        System.out.println("Det totala antalet tecken i listan: " + totalCharCount());
        System.out.println("Är alla ord kortare än 12 tecken? " + allShorterThan12());
        System.out.println("Är all ord längre än två bokstäver? " + allLongerThan2());
    }


    //1- Hur många ord med fler än 8 bokstäver innhåller texten?
    private int nOWordsLongerThan8(){
        Stream<String> stream = Arrays.stream(StringArrayData.austin);
        return (int) stream.filter(word -> word.toCharArray().length> 8).count();
    }


    //2- Hur många unika ord innehåller texten?
    private int nOUniqueWords(){
        int uniqueWordCount = (int)Arrays.stream(StringArrayData.austin)
                .map(String::toLowerCase)
                // Build a map from word -> frequency
                .collect(Collectors.groupingBy(w -> w, Collectors.counting()))
                // stream the frequency map entries
                .entrySet().stream()
                // filter to retain unique words (with frequency == 1)
                .filter(e -> e.getValue() == 1)
                // count them
                .count();
        return uniqueWordCount;
    }

    //3- hur många ord med färre än 4 tecken?
    private int nOWordsShorterThan4() {
        int numberOfWords = (int) Arrays.stream(StringArrayData.austin).filter(word -> word.toCharArray().length < 4).count();
        return numberOfWords;
    }

    //4- Hur många unika ord med fler än 8 bokstäver?
    private int nOUniqueWordsLongerThan8(){
        int uniqueWordCount = (int) Arrays.stream(StringArrayData.austin)
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
        return uniqueWordCount;
    }


    //5- Vilken är den genomsnittliga ordlängden?
    private double averageWordLength(){
        double averageLength = Arrays.stream(StringArrayData.austin).mapToInt(String::length).average().getAsDouble();
        return averageLength;
    }

    //6- Det totala antalet tecken i listan (dvs summan av längden av alla ingående strängar)?
    private int totalCharCount(){
        return Arrays.stream(StringArrayData.austin).mapToInt(String::length).sum();

    }


    //7-a Är alla ord kortare än 12 tecken?
    private boolean allShorterThan12(){
        Predicate<String> shorterThan12 = s -> s.length() >12;
        int wordCount = (int) Arrays.stream(StringArrayData.austin).filter(shorterThan12).count();
        return ((wordCount > 0));
    }


    //7-b  Är all ord längre än tvåbokstäver?
    private boolean allLongerThan2(){
        Predicate<String> longerThan2 = s -> s.length() < 2;
        int wordCount = (int) Arrays.stream(StringArrayData.austin).filter(longerThan2).count();
        return ((wordCount>0));
    }


}
