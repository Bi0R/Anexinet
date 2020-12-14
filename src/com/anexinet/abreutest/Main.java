package com.anexinet.abreutest;

import com.anexinet.abreutest.addition.AdditionWithoutAritmethic;
import com.anexinet.abreutest.coincidences.CoincidenceFinder;
import com.anexinet.abreutest.baseconversion.NumberConverter;
import com.anexinet.abreutest.longestWord.SentenceProcessor;
import com.anexinet.abreutest.matrix.MatrixProcessor;
import com.anexinet.abreutest.romans.RomanNumeralConverter;
import com.anexinet.abreutest.permutations.PermutationFinder;
import com.anexinet.abreutest.utils.MatrixPrinter;

import java.util.Arrays;

public class Main {
    private static int[][]testMatrix={{1,2,3},
                            {4,0,6},
                            {7,8,9}};

    public static void main(String[] args) {
        System.out.println("Question 1: add two numbers without aritmethic operator");
        System.out.println("5+11="+ AdditionWithoutAritmethic.addTwoNumbers(5,11));
        System.out.println("Question 2: Get coincidences between 2 strings");
        System.out.println("asdfghjwertyuicvbn  and digezponc, coincidences: ");
        Character []coincidences = CoincidenceFinder.getCoincidencesInTwoString("asdfghjwertyuicvbn","digezponc");
        Arrays.stream(coincidences).forEach(element->System.out.print(element));
        System.out.println("Question 3: convert number in a given base to int");
        System.out.println("FFF is equivalent to "+ NumberConverter.converToDecimal("FFF",16));
        System.out.println("Question 4: convert zero rows and columns where there is already a zero");
        MatrixPrinter.printMatrix(testMatrix);
        System.out.println("Result: ");
        MatrixProcessor.convertRowsAndColumnsToZero(testMatrix);
        System.out.println("Question 5: convert int between 1 and 3999 to roman numeral ");
        System.out.println("3512 to Roman= "+ RomanNumeralConverter.getRomanNumeral(3512));
        System.out.println("Question 6: get all String permutations ");
        PermutationFinder.printPermutations("java");
        System.out.println("\n\nQuestion 7: get longest word in a sentence ");
        String sentence = "Failure is simply the opportunity to begin again, this time more intelligently.";
        System.out.println("The longest word in '"+sentence+"' is: ");
        String[] longestWord = SentenceProcessor.getLongestWord(sentence);
        Arrays.stream(longestWord).sequential().forEach(word->System.out.print(" "+word));
    }
}
