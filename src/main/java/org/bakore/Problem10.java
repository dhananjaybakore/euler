package org.bakore;


import java.util.ArrayList;
import java.util.List;

public class Problem10 {

    private static final int JUMP = 100000;
    private static final int DEFAULT_SIZE = 100023;
    private static final long BELOW_NO= 2000000L;

    public static void main(String [] args){
        List<Long> primes = new ArrayList<>();
        // 2 is a special Case as its the only even prime number.
        primes.add(2L);
        boolean keepRunning = true;

        long i=3;
        while(keepRunning){
            keepRunning =  runSegments(i, i+JUMP, primes);
            i+=JUMP;
        }

        Long sum = 0L;
        for(Long prime: primes){
            sum+=prime;
        }

        System.out.println(sum);
    }



    private static boolean runSegments(long start, long end, List<Long> primes){
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
                if(i>BELOW_NO)
                    return  false;

                primes.add(i);
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
