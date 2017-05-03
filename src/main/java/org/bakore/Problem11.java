package org.bakore;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem11 {


    private static int [][] INPUT = new int[20][20];

    static {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(Problem11.class.getResourceAsStream("/Problem11Input.txt")))){

            String line;
            int i=0;
            while((line=reader.readLine())!=null){
                //System.out.println(line);
                String [] strNum = line.split(" ");
                for(int k=0; k<strNum.length; k++){
                    INPUT[i][k] = Integer.parseInt(strNum[k]);
                }
                i++;
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    private static final int ADJ_CT=4;
    public static void main(String[] args){

        long topDown = topDown();
        long leftDiagonal = leftdiagonal();
        long rightDiagonal= rightdiagonal();
        long leftRight = leftRight();

        long largest = 0;
        if(topDown>largest){
            largest = topDown;
        }
        if(leftDiagonal>largest){
            largest = leftDiagonal;
        }
        if(rightDiagonal>largest){
            largest=rightDiagonal;
        }
        if(leftRight>largest){
            largest = leftRight;
        }

        System.out.println("LARGEST: "+largest);



    }

    private static long topDown(){
        long largest = 1;
        for(int k=0; k<20; k++){
            for(int i=0; i< 20-ADJ_CT; i++){
                long temp = INPUT[i][k]
                        * INPUT[i+1][k]
                        *INPUT[i+2][k]
                        *INPUT[i+3][k];
                if(temp>largest)
                    largest = temp;

            }
        }
        System.out.println("Largest Top Down: "+largest);

        return largest;
    }


    private static long leftRight(){
        long largest = 1;

        for(int i=0; i< 20; i++){
            for(int k=0; k<20-ADJ_CT+1; k++){

                long temp = INPUT[i][k]
                        * INPUT[i][k+1]
                        *INPUT[i][k+2]
                        *INPUT[i][k+3];
                if(temp>largest)
                    largest = temp;

            }
        }
        System.out.println("Largest Left Right: "+largest);
        return largest;
    }

    private static long leftdiagonal(){
        long largest = 1;

        for(int i=0; i< 20-ADJ_CT+1; i++){
            for(int k=0; k<20-ADJ_CT+1; k++){
                long temp = INPUT[i][k]
                        * INPUT[i+1][k+1]
                        *INPUT[i+2][k+2]
                        *INPUT[i+3][k+3];
                if(temp>largest)
                    largest = temp;

            }
        }
        System.out.println("Largest Left Diagonal: "+largest);
        return largest;
    }

    private static long rightdiagonal(){
        long largest = 1;

        for(int i=0; i<20-ADJ_CT+1; i++){
            for(int k=19; k>=ADJ_CT-1; k--){
                long temp = INPUT[i][k]
                        * INPUT[i+1][k-1]
                        *INPUT[i+2][k-2]
                        *INPUT[i+3][k-3];
                if(temp>largest)
                    largest = temp;

            }
        }
        System.out.println("Largest Right Diagonal: "+largest);
        return largest;
    }
}
