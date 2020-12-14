package com.anexinet.abreutest.longestWord;

import java.util.*;
import java.util.stream.Collectors;

public class SentenceProcessor {
    /**
     * Function to get the longest word from a sentence, more than one result is possible, but not repeated words
     * @param sentence sentence to validate
     * @return an array with the longest word(s)
     */
    public static String[] getLongestWord(String sentence){
        List<String> longestWords = new ArrayList<>();
        Set<String> uniqueWords = new HashSet<>();
        // Remove spaces at the end and begining
        sentence = sentence.trim();

        // Regex for splitting in words
        String regexNonWord = "\\W+";
        // Split in words not including characters
        String[] words = sentence.split(regexNonWord);
        //Add words to set (Removing repeated)
        Arrays.stream(words).forEach(word->uniqueWords.add(word));
        //Convert to List and sort it by size
        List<String> sortedWords = uniqueWords.stream().collect(Collectors.toList());
        Collections.sort(sortedWords, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s2.length()-s1.length();
            }
        });
        //Max size
        int maxSize = sortedWords.get(0).length();
        //Get Longest words
        for(String word: sortedWords){
            if(word.length()==maxSize){
                longestWords.add(word);
            }else if(word.length()<maxSize){//if the size is less than max Size finish cicle
                break;
            }
        }
        return longestWords.toArray(String[]::new);
    }
}
