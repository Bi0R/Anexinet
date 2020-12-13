package com.anexinet.abreutest;

import com.anexinet.abreutest.question1.AnswerOne;
import com.anexinet.abreutest.question2.AnswerTwo;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here

        System.out.println("Question One add two numbers without aritmethic operator");
        System.out.println("5+11="+new AnswerOne().addTwoNumbers(5,11));
        System.out.println("Get coincidences between 2 strings");
        System.out.println("asdfghjwertyuicvbn  and digezponc, coincidences: ");
        Character []coincidences =new AnswerTwo().getCoincidencesInTwoString("asdfghjwertyuicvbn","digezponc");
        Arrays.stream(coincidences).forEach(element->System.out.print(element));
    }
}
