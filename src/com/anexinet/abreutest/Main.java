package com.anexinet.abreutest;

import com.anexinet.abreutest.question1.AnswerOne;
import com.anexinet.abreutest.question2.AnswerTwo;
import com.anexinet.abreutest.question3.AnswerThree;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println("Question 1: add two numbers without aritmethic operator");
        System.out.println("5+11="+new AnswerOne().addTwoNumbers(5,11));
        System.out.println("Question 2: Get coincidences between 2 strings");
        System.out.println("asdfghjwertyuicvbn  and digezponc, coincidences: ");
        Character []coincidences =new AnswerTwo().getCoincidencesInTwoString("asdfghjwertyuicvbn","digezponc");
        Arrays.stream(coincidences).forEach(element->System.out.print(element));
        System.out.println("Question 3: convert number in a given base to int");
        System.out.println("FFF is equivalent to "+ new AnswerThree().converToDecimal("FFF",16));
    }
}
