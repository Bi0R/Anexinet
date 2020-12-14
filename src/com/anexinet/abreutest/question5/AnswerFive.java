package com.anexinet.abreutest.question5;

public class AnswerFive {
    //Numbers used in roman numerals the order is important
    private static String[][] romanNumbers={{"I", "V"},
                                            {"X","L"},
                                            {"C","D"},
                                            {"M",""}};

    /**
     * Converts an int between 1 and 3999 to Roman numeral
     * @param number number to be converted
     * @return
     */
    public static String getRomanNumeral(int number){
        StringBuilder romanNumeral = new StringBuilder();
        if(number>=1 &&number<=3999){
            char[] digits = new StringBuilder(number+"").reverse().toString().toCharArray();
            /*index i is not only the position in the array it also represents if the current digit
            is multiplied by 10⁰, 10¹, 10² or 10³, based on that we decide which character to use*/
            for(int i =0; i<digits.length; i++){
                Integer digit = Integer.parseInt(digits[i]+"",10);
                if(digit<=3){//for this case just repeat unity value
                    romanNumeral.append(repeatStringNTimes(romanNumbers[i][0],digit));
                }else if(digit==4){//special case unity value followed by 5 value
                    romanNumeral.append(romanNumbers[i][0]+romanNumbers[i][1]);
                }else if(digit==5){//special case five value
                    romanNumeral.append(romanNumbers[i][1]);
                }else if(digit>5 && digit <=8){//five value followed by unity value(s)
                    romanNumeral.append(romanNumbers[i][1]);//5 value
                    romanNumeral.append(repeatStringNTimes(romanNumbers[i][0],digit-5));
                }else{//for nine unity value followed for next level unity value
                    romanNumeral.append(romanNumbers[i][0]+romanNumbers[i+1][0]);
                }
            }

        }else{
            romanNumeral.append("Number not in range");
        }
        return romanNumeral.reverse().toString();
    }

    /**
     * Repeats a given string N times
     * @param string the string to be repeated
     * @param times number of times to repear the string
     * @return
     */
    private static String repeatStringNTimes(String string, int times){
        StringBuilder result = new StringBuilder();
        for(int i=0; i<times; i++){
            result.append(string);
        }
        return  result.toString();
    }
}
