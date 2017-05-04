package org.bakore;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;


public class Problem14 {

    public static void main(String[] args){

        long startTime = System.nanoTime();
        Long largestPathPrime=2L;
        int largestPath=0;
        for(Long prime=1L ; prime<1000000; prime++){
            int collatzPathLength = getCollatzPathLength(prime);
            if(collatzPathLength>largestPath){
                largestPath=collatzPathLength;
                largestPathPrime=prime;
            }
           // System.out.println("Number: "+ prime + " collatzPathLength: "+ collatzPathLength);
        }
        long endTime = System.nanoTime()-startTime;
        System.out.println("Largest Number: "+ largestPathPrime + " Largest Path: "+ largestPath + "With Time: "+ endTime/1000000);

    }

    private static int getCollatzPathLength(Long number) {
        int path=1;
        while(number!=1){
            if(number%2==0){
                number = number/2;
            }else{
                number = 3* number+1;
            }
            path++;
        }
        return  path;
    }

}
