package org.bakore;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Problem18And67 {

    //Change this to 15 for Problem 18 and the input file to Problem18Input.txt
    private static final int ROWS=100;
    private static int [][] MAP =  new int[ROWS][ROWS];
    static {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(Problem18And67.class.getResourceAsStream("/Problem67Input.txt")))){
            String line;
            int i=0;
            while((line=reader.readLine())!=null){
                String [] strNum = line.split(" ");
                for(int k=0; k<strNum.length; k++){
                    MAP[i][k] = Integer.parseInt(strNum[k]);
                }
                i++;
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void main (String [] args){
        for(int row = ROWS-2; row>=0;row--){
            for (int col=0; col<=row; col++){
                MAP[row][col]+= getMax(MAP[row+1][col+1],MAP[row+1][col]);
            }
        }
        System.out.println("Answer: "+ MAP[0][0]);
    }

    private static int getMax(int i, int k) {
        if(i<k)
            return k;
        else
            return i;
    }
}
