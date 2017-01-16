import java.util.ArrayList;
import java.util.List;

/**
 * Created by MihaelKO on 16.01.2017. start - 12.45, end 16.40. Whith a lunch brake
 */
public class Main {
    public static void main(String[] args) {
        int a = 100, b = 999; //Initialize two numbers, first is min of 3-digit numbers, second is max
        List<String> resultList = new ArrayList();//Initialize list where our palindroms we'll be stored
        //List<Integer> resultList = new ArrayList();//Line with initialization of integer List
        while (a <= b) { //Start cycle
            int c = a * b; //get multiplication og two numbers
            a++; // make all numbers are been multiplicated
            isPalindrome(resultList, c);//check if the current number palindrom or not, and if it so, wright it to List
        }
        try{
            System.out.println("The largest palindrome made from the product of two numbers is: "
                    + resultList.get(resultList.size()-1)); //Print text if List have palindrom. Print only max palindrom
        }catch (ArrayIndexOutOfBoundsException e){ //catch exception if there is no palindroms at all and the List is Empty
            System.out.println("There is no largest palindrome made from the product of two 3-digit numbers.");
        }
    }

    @SuppressWarnings("unchecked")
    private static void isPalindrome(List resultList, int c) { //method for checking palindrom
        String string = String.valueOf(c); // converting number to string
        char[] myCharArray = string.toCharArray(); //split string to array of chars
        char[] myTempArray = new char[myCharArray.length];//make temporary empty array with lenght equals of char array
        String reverse = ""; // initialize empty string
        for (int i = myCharArray.length - 1; i >= 0; ) { //initialize counter for string array and if it is not empty
            for (int j = 0; j < myTempArray.length; j++) {//initialize counter for temporary array
                myTempArray[j] = myCharArray[i];//assign char from string array to empty array in mirroring mode
                i--;//get previous number from last char
                reverse += myTempArray[j];//start filling reversed string
            }
        }
       /* In case if we need integers uncomment this code and line with Integer List
        int num = Integer.parseInt(reverse);
        if (c == num) { //check if strings are equal
            resultList.add(c);//and if equal add this number to List of palindroms
        }
        */
        if (string.equals(reverse)) { //check if strings are equal
                resultList.add(string);//and if equal add this number to List of palindroms
        }
    }
}

