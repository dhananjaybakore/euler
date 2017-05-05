package org.bakore;

import java.math.BigInteger;

public class Problem16 {

    public static void main(String[] args){

        // Implement this without using Big Integer - TBD
        String s = String.valueOf(BigInteger.ONE.shiftLeft(1000));
        int sum =0;
        for(char c: s.toCharArray()){
            sum+= Character.getNumericValue(c);
        }

        System.out.println("Sum: "+ sum);

    }

}
