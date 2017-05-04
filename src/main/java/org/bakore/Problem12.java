package org.bakore;

import java.util.*;

public class Problem12 {


    private static final int LIMIT=20000;

    public static void main(String[] args){
        int traingleNumber=0;
        long startTime= System.nanoTime();
        for(int i=1; i<100000; i++){
            traingleNumber+=i;
            if(noOfFactors(traingleNumber)>=500){
                System.out.println("Traingle Number: "+ traingleNumber);
                break;
            }
            //System.out.println(traingleNumber);
        }
        double endTime = (System.nanoTime()-startTime);
        System.out.println("Time Taken: "+ endTime);
    }

    private static int noOfFactors(int number){
        int noOfFactors = 1;
        int[] primeFactors = primeFactors(number);


        for(int primeCount: primeFactors){
            if(primeCount>0)
                noOfFactors*=(primeCount+1);
        }
        //System.out.println("Traingle Number: "+ number+" No of Factors: "+ noOfFactors);
        return  noOfFactors;
    }


    private static int[] primeFactors(int number){
        int[] primeFactors = initializeEmptyArray();
        while(number%2==0){
            number = number /2;
            primeFactors[2]++;
        }
        // we have removed all factors of 2 so now there are only odd numbers
        for(int i=3; i<=Math.sqrt(number); i+=2){
            while(number%i==0){
                number = number/i;
                primeFactors[i]++;
            }
        }
        //if number is a prime number greater than 2?
        if(number>2){
            primeFactors[number]++;
        }
        return primeFactors;
    }



    private static int[] initializeEmptyArray() {
        int [] arr = new int[LIMIT];
        for(int i=0; i<LIMIT; i++){
            arr[i]=0;
        }
        return arr;
    }
}



