package com.anexinet.abreutest.question1;

import static com.anexinet.abreutest.utils.Contants.*;

public class AnswerOne {
    private char remainder = ZERO;

    /**
     * Adds two numbers without using aritmethic operators, only positive numbers
     * @param numberOne
     * @param numberTwo
     * @return result of the addition
     */
    public int addTwoNumbers(int numberOne, int numberTwo){
        /*
        There is a common solution using binary operations like <<, &, etc, I decided to make something different
        mainly because it would be different to know if the solution was copied or original.
        * */
        char[] binaryOne = new StringBuilder(Integer.toBinaryString(numberOne)).reverse().toString().toCharArray();
        char[] binaryTwo = new StringBuilder(Integer.toBinaryString(numberTwo)).reverse().toString().toCharArray();
        int maxSize = binaryOne.length>binaryTwo.length?binaryOne.length:binaryTwo.length;
        StringBuilder result = new StringBuilder();
        for(int index = 0; index<maxSize; index++){
            char digitOne;
            char digitTwo;
            char previousReminder = remainder;
            //dealing with binary numbers with different lengths
            if(index >= binaryOne.length){
                digitOne = ZERO;
                digitTwo = binaryTwo[index];
            }else if(index >= binaryTwo.length){
                digitOne = binaryOne[index];
                digitTwo = ZERO;
            }else{
                digitOne = binaryOne[index];
                digitTwo = binaryTwo[index];
            }
            //taking care of any previous remainder
            boolean preserveRemainderAfterIteration = previousReminder==ONE&&digitOne==ONE;
            digitOne = addTwoBinaryDigits(digitOne, previousReminder);
            //adding two digits
            digitOne = addTwoBinaryDigits(digitOne, digitTwo);
            result.append(digitOne);//adding to the result
            remainder=preserveRemainderAfterIteration?previousReminder:remainder;
        }
        //Adding a possible reminder
        result.append(remainder);
        return Integer.parseInt(result.reverse().toString(),2);
    }

    /**
     *
     * @param digitOne first binary digit
     * @param digitTwo second binary digit
     * @return the result of the addition and updates the remainder variable
     */
    private char addTwoBinaryDigits(char digitOne, char digitTwo){
        if(digitOne!=digitTwo){//if the digits are different one of the must be one and the other zero
            remainder = ZERO;
            return ONE;
        }else if(digitOne == ONE){//if both digits are equal, they could be 0 & 0 or 1 & 1
                remainder = ONE;//1+1 =10, hence return 0 and remainder = 1
                return ZERO;
        }else{//both zero
                remainder = ZERO;
                return ZERO;
        }
    }
}
