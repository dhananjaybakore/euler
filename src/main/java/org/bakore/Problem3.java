package org.bakore;

import org.bakore.utils.SegmentedSieve;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Problem3 {
    private static final int JUMP = 100000;
    private static final long UPPERLIMIT = 600851475143L;
    public static void main(String[] args){

        long startTime = System.nanoTime();
        List<Long> primes = new ArrayList<Long>();
        primes.add(2L);
        primes.add(3L);
        primes.add(5L);
        primes.add(7L);
        primes.add(11L);
        primes.add(13L);
        primes.add(17L);
        primes.add(23L);
        for (long i=27; i<=Math.sqrt(UPPERLIMIT); i+=JUMP){
            //For each Segment
            SegmentedSieve.runSegments(i, i+JUMP, primes);
            System.out.println("Segment Complete: "+ i);
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
        System.out.println("Total Time Taken: "+ totalTime);
    }
}
