package org.bakore;

import java.util.ArrayList;
import java.util.List;


public class Problem7 {

    private static final int JUMP = 100000;
    private static final long UPPERLIMIT = 600851475143L;
    private static final int DEFAULT_SIEVE_SIZE = 100023;
    private static int PRIMECOUNTER=1;
    private static final int N =10001;
    public static void main(String[] args){

        long startTime = System.nanoTime();
        List<Long> primes = new ArrayList<Long>();
        primes.add(2L);
        Integer primeCounter = 1;
        Integer n = 10002;
        for (long i=3; i<=Math.sqrt(UPPERLIMIT); i+=JUMP){
            //For each Segment, returns false once the Nth Prime number is found.
            if(!runSegments(i, i+JUMP, primes)){
               break;
            }
           // System.out.println("Segment Complete: "+ i);
        }

    }

    private static boolean runSegments(long start, long end, List<Long> primes){
        boolean [] sieve = initializeSieve(DEFAULT_SIEVE_SIZE);
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
                PRIMECOUNTER++;
                if(PRIMECOUNTER==N){
                    System.out.println("Nth Prime Number: "+ i);
                    return false;

                }
                // System.out.println(i);
            }
        }
        return true;
    }


    private static boolean[] initializeSieve(int size){
        boolean [] sieve = new boolean[size];
        for(int i=0; i< size; i++){
            sieve[i] =true;
        }
        return sieve;
    }

}
