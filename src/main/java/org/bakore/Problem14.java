package org.bakore;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;


public class Problem14 {

    private static final int SIZE=1000000;
    private static int[] cache = initializeEmptyArray();

    public static void main(String[] args) throws Exception{

        long startTime = System.nanoTime();
        Long largestPathNumber=2L;
        int largestPath=0;

        for(Long i=1L ; i<SIZE; i++){
            int collatzPathLength = getCollatzPathLengthCache(i);
            cache[i.intValue()]=collatzPathLength;
            if(collatzPathLength>largestPath){
                largestPath=collatzPathLength;
                largestPathNumber=i;
            }
            //System.out.println("Number: "+ i + " collatzPathLength: "+ collatzPathLength);
        }
        long endTime = System.nanoTime()-startTime;
        System.out.println("Largest Number: "+ largestPathNumber + " Largest Path: "+ largestPath + "With Time: "+ endTime/1000000);

    }

    private static int getCollatzPathLengthCache(Long number){
        int path=1;
        while(number!=1L){
            int pathInCache = getCacheValue(number);
            if(pathInCache!=-1){
                path+=pathInCache;
                number=1L;
            }else{
                if(number%2==0){
                    number = number/2;
                }else{
                    number = 3* number+1;
                }
                path++;
            }
        }
        return  path;
    }

    private static int getCollatzPathLength(Long number){
        int path=1;
        while(number!=1L){
            if(number%2==0){
                number = number/2;
            }else{
                number = 3* number+1;
            }
            path++;

        }
        return  path;
    }
    private static int getCacheValue(Long number) {
       if(number>=SIZE){
            return -1;
        }
        return cache[number.intValue()];
    }


    private static int[] initializeEmptyArray() {
        int [] arr = new int[SIZE];
        for(int i=0; i<SIZE; i++){
            arr[i]=-1;
        }
        return arr;
    }
}
