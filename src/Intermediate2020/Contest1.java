/*
Ethan Yu
iTalented
Contest 1
Java
 */

package Intermediate2020;

import java.util.Scanner;
import java.lang.StringBuilder;

public class Contest1 {

    public static void main(String [] args) {

        Scanner sc = new Scanner (System.in);

        long n; //because values can go up to 14 digits
        int p;

        for (int i = 0; i < 5; i++) { //Reading in input ad hoc because output can be calculated line by line
            n = sc.nextLong();
            p = sc.nextInt();
            StringBuilder temp = new StringBuilder(String.valueOf(n));
            p = temp.length() - p; //Manipulate p to desired index
            if ((p < 0) || (p >= temp.length())) { //Edge cases
                System.out.println(i+1 + ".  " + temp);
                continue;
            }
            int[] output = new int[temp.length()]; //int array to store output (no need for String/int digit manipulation)
            for (int j = 0; j < p; j++) { //populate "first half" of output //using % 10 to take care of summing over 10
                output[j] = (Character.getNumericValue(temp.charAt(p)) + Character.getNumericValue(temp.charAt(j))) % 10;
            }
            output[p] = Character.getNumericValue(temp.charAt(p)); //populate unchanged value
            for (int j = p + 1; j < output.length; j++) {  //populate second half
                output[j] = Math.abs(Character.getNumericValue(temp.charAt(j)) - Character.getNumericValue(temp.charAt(p))) % 10;
            }
            temp = new StringBuilder(); //reuse temp for output
            for (int value : output) {
                temp.append(value); //populate temp with output (converting int array to String)
            }
            System.out.println(i+1 + ".  " + temp); //Print out
        }

    }

}
