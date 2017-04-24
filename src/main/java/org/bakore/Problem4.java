package org.bakore;


public class Problem4 {


    int [] primes = {2,3,5,7,11,13,17,23};

    // Largest Palindrome from a Product of 2 three digit numbers is of atleast
    // Palindrome is 6 Digit
    // No of 6 Digit Palindromes: xyzzyx  9 values for x, 10 values for y and z each. hence we have 900 6 Digit palindromes
    // Start x , y, z from 9 andd find if palindrome is a factor of 2  3 digit numbers
    //
    public static void main(String [] args){

        for(int x=9; x>=1; x--){
            for(int y=9; y>=0; y--){
                for(int z=9; z>=0; z--){
                    if(isAProductOfTwoNDigitNumbers(x,y,z)){
                        System.out.println("Palindrome: x: "+x+" y: "+y+" z: "+z);
                        return;
                    }
                }
            }
        }

    }

    private static boolean isAProductOfTwoNDigitNumbers(int x, int y, int z) {
        int number = getNumber(x,y,z);
        System.out.println("Checking Palindrome: "+ number);
        for(int i=999 ; i>=100 ; i--){
            //Atleast one factor is a multiple of 11
            for(int k=979; k>=100 ; k-=11){
                if(i*k == number){
                    System.out.println(" "+ i+ " * "+ k+" = "+ number);
                    return true;
                }
            }
        }
        return false;
    }

    private static int getNumber(int x, int y, int z) {

        return 11* (9091 * x + 910* y + 100 * z) ;
    }


}
