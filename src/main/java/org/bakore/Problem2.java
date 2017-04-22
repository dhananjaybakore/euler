package org.bakore;
public class Problem2 {


    public static void main (String [] args){
        int result =2;
        int fibn1 = 2, fibn2=1, fibn=0;
        while (fibn <= 4000000){
            fibn = fibn1 + fibn2;
            fibn2 = fibn1;
            fibn1=fibn;
            if(fibn%2==0){
                result+= fibn;
            }
        }
        System.out.println("Result: "+ result);
    }


}
