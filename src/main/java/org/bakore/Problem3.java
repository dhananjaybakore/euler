package org.bakore;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Problem3 {
    private static final int JUMP = 100000;
    private static final long UPPERLIMIT = 600851475143L;
    private static final int DEFAULT_SIZE = 100023;
    public static void main(String[] args){

        long startTime = System.nanoTime();
        List<Long> primes = new ArrayList<Long>();
        // 2 is a special Case as its the only even prime number.
        primes.add(2L);

        for (long i=3; i<=Math.sqrt(UPPERLIMIT); i+=JUMP){
            //For each Segment
            runSegments(i, i+JUMP, primes);
           // System.out.println("Segment Complete: "+ i);
        }

        ListIterator<Long> li = primes.listIterator(primes.size());
        while (li.hasPrevious()){
            long prime = li.previous();
            if(UPPERLIMIT%prime==0){
                System.out.println("Final Answer: "+ prime);
                break;
            }
        }
        long endTime = System.nanoTime();
        long totalTime = (endTime-startTime)/1000000;
        System.out.println("Total Time Taken: "+ totalTime +" Milliseconds.");
    }


    private static void runSegments(long start, long end, List<Long> primes){
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
