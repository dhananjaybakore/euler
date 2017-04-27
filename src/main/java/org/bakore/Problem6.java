package org.bakore;

public class Problem6 {
    // Not sure why this problem is in Project Euler?

    public static void main (String [] args ){
        int sum1= 0;
        for(int i=1; i<=100; i++){
            sum1 += i*i;
        }

        int answer = (5050*5050) - sum1;
        System.out.println(answer);
    }
}

