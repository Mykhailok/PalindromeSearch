import java.util.*;

/**
 * Created by MihaelKO on 16.01.2017. start - 12.45, end 16.10.
 */
public class Main {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int a = 100, b = 1000; //Initialize two numbers, first is min of 3-digit numbers, second is max
        TreeSet<Integer> resultList = new TreeSet();//Line with initialization of integer List
        for (int i = a; i < b; i++) { //Start cycle
            for (int j = a; j < b; j++){
                int c = i * j; //get multiplication of two numbers
                isPalindrome(resultList, c);//check if the current number palindrom or not, and if it so, wright it to List
            }
        }
        try{
            System.out.println("The largest palindrome made from the product of two numbers is: "
                    + resultList.last()); //Print text if List have palindrom. Print only max palindrom
        }catch (ArrayIndexOutOfBoundsException e){ //catch exception if there is no palindroms at all and the List is Empty
            System.out.println("There is no largest palindrome made from the product of two 3-digit numbers.");
        }
    }

    @SuppressWarnings("unchecked")
    private static void isPalindrome(Set<Integer> resultList, int c) { //method for checking palindrom
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
        int num = Integer.parseInt(reverse); //convert to Integer
        if (c == num) { //check if strings are equal
            resultList.add(c);//and if equal add this number to List of palindroms
        }
    }
}

