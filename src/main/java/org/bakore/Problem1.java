package org.bakore;

/**
 * Created by dhananjay on 4/15/17.
 */
public class Problem1 {


    private static final int LIMIT = 1000;
    public static void main(String [] args){
        int result = 0;
        int noOfCalculations=0;
        for(int i=0; i<LIMIT; i=i+3){
                result += i;
            noOfCalculations++;
        }
        for(int i=0; i<LIMIT; i=i+5){
            result += i;
            noOfCalculations++;
        }
        //Subtract the ones counted twice
        for(int i=0; i<LIMIT; i=i+15){
            result -= i;
            noOfCalculations++;
        }
        System.out.println("Result: "+ result+ "With No Of Calculations: "+ noOfCalculations);
    }


}
