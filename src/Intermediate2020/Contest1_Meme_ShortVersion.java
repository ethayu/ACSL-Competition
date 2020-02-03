package Intermediate2020;/*
Ethan Yu
iTalented
Contest 1
Java
 */
//package Intermediate2020;
import java.util.Scanner;
import java.lang.StringBuilder;
import java.lang.Math;
public class Contest1_Meme_ShortVersion {
    public static void main(String [] args) {
        Scanner sc = new Scanner (System.in);
        long n;
        int p;
        for (int i = 0; i < 5; i++) { 
            n = sc.nextLong();
            p = (int)Math.log10(n) + 1 - sc.nextInt();
            System.out.print(i+1 + ". ");
            for (int j = 0; j <= (int)Math.log10(n); j++) {
                if (j == p) System.out.print((int)(n / Math.pow(10.0, (int)Math.log10(n) - p)) % 10);
                else if (j < p) System.out.print((((int)(n / Math.pow(10.0, (int)Math.log10(n) - j)) % 10) + (int)(n / Math.pow(10.0, (int)Math.log10(n) - p)) % 10) % 10);
                else System.out.print(Math.abs((((int)(n / Math.pow(10.0, (int)Math.log10(n) - j)) % 10) - (int)(n / Math.pow(10.0, (int)Math.log10(n) - p)) % 10)) % 10);
            }
            System.out.println();
        }
    }
}
