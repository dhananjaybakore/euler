package org.bakore.utils;

import java.util.ArrayList;
import java.util.List;

public class SegmentedSieve {
    private static final int DEFAULT_SIZE = 100023;

    public static List<Integer> generatePrimes(int upperLimit){
        boolean[] sieve = initializeSieve(DEFAULT_SIZE);
        List<Integer> primes = new ArrayList<Integer>();
        for(int i=2; i<=Math.sqrt(upperLimit);i++){
            if(sieve[i]){
                for(int j=i*i ; j <=upperLimit; j+=i){
                    sieve[j]=false;
                }
            }
        }
        int count =0;
        for(int i=2; i<upperLimit; i++){
            if(sieve[i]){
                count++;
                System.out.println(i+" ");
                primes.add(i);
            }
        }
        System.out.println("Total Primes Found: "+ count);
        return primes;
    }



    public static void runSegments(long start, long end, List<Long> primes){
        boolean [] sieve = initializeSieve(DEFAULT_SIZE);
        for (long prime: primes){
            for(Long j=prime*prime ; j<=end; j+=prime){
                if(j>=start ){
                    sieve[(int)(j-start)]=false;
                }
            }
        }
        for(long i=start; i<=Math.sqrt(end);i++){
            if(sieve[(int)(i-start)]){
                for(long j=i*i ; j <=end; j+=i){
                    sieve[(int)(j-start)]=false;
                }
            }
        }
        for(Long i= start; i<end ; i=i+2){
            if(sieve[(int)(i-start)]){
                primes.add(i);
               // System.out.println(i);
            }
        }

    }


    private static boolean[] initializeSieve(int size){
        boolean [] sieve = new boolean[size];
        for(int i=0; i< size; i++){
            sieve[i] =true;
        }
        return sieve;
    }
}
