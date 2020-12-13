package com.anexinet.abreutest.question2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class AnswerTwo {
    /**
     * Returns an array of matches between two string with O(n) = n, with n being the size of the shortest string
     * @param firstString
     * @param secondString
     * @return
     */
    public Character[] getCoincidencesInTwoString(String firstString, String secondString){
        List<Character> coincidences = new ArrayList<>();
        //First we find the shortestString to reduce iterations
        String shortestString;
        String longestString;
        if(firstString.length()>secondString.length()){
            shortestString = secondString;
            longestString = firstString;
        }else{
            shortestString = firstString;
            longestString = secondString;
        }
        //if the char is in the longest string we add it to the results
        for(char character: shortestString.toCharArray()){
            if(longestString.indexOf(character)!=-1){
                coincidences.add(character);
            }
        }
        //returning an array of the exact size of the coincidences
        Character[] result = new Character[coincidences.size()];
        return coincidences.toArray(result);
    }
}
