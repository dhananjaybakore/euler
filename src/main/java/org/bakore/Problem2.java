package org.bakore;

/**
 * Created by dhananjay on 4/16/17.
 */
public class Problem2 {

    // f(n) = f(n-1) + f(n-2)
    // f(4) = f(3) + f(2)
    // f(6) = f(5) + f(4)
    // f(8) = f(7) + f(6)
    // f(10) = f(8) + f(8) + f(6) +f(4) + f(2) + 1
    // 1 ,2 ,3,5 ,8 ,13,21 ,34 ,55,89 ,144, 233,377,


    // Property :
    // Even + Odd = Odd
    // Odd + Odd = Even
    // Hence an even valued fibonacci number will always come after 2 consecutive odd numbers

    public static void main (String [] args){
        int result =2;
        int fibn1 = 2, fibn2=1, fibn=0;
        while (fibn <= 4000000){
            fibn = fibn1 + fibn2;
            fibn2 = fibn1;
            fibn1=fibn;
            if(fibn%2==0){
                result+= fibn;
            }
        }
        System.out.println("Result: "+ result);
    }


}
