package com.anexinet.abreutest.permutations;

public class PermutationFinder {
    /**
     * Functions that returns a String with all the permutations of a function
     * @param toPermute
     * @return
     */
    public static void printPermutations(String toPermute){
        if(toPermute!=null || toPermute.length()>0){
            System.out.println("The permutations for "+toPermute+" are: \n");
            permuteString(toPermute,"");
        }else{
            System.out.println("Invalid/empty String");
        }
    }

    /**
     * Recursive function to get the permutations
     * @param toPermute the part of the string that still needs to be permuted
     * @param fixed the part that at this point is already fixed
     */
    private static void permuteString(String toPermute, String fixed){
        //If there is nothing else for be permuted we already have the full permutation
        if(toPermute.length()==0){
            System.out.print("  "+fixed);
            return;
        }
        //Iterate over string to be permuted and fix each one of the characters
        for(int i=0; i<toPermute.length();i++){
            permuteString(toPermute.substring(0,i)+toPermute.substring(i+1)
                    , fixed+toPermute.charAt(i));
        }
    }
}
