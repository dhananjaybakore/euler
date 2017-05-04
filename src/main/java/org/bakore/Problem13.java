package org.bakore;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem13 {

    private static final int LIMIT = 100;
    private static int [][] INPUT = new int[100][50];

    static {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(Problem11.class.getResourceAsStream("/Problem12Input.txt")))){

            String line;
            int i=0;
            while((line=reader.readLine())!=null){
                //System.out.println(line);
                char [] strNum = line.toCharArray();
                for(int k=0; k<strNum.length; k++){
                    INPUT[i][k] = Character.getNumericValue(strNum[k]);
                }
                i++;
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private static int[] sum = initializeEmptyArray();

    private static int[] initializeEmptyArray() {
        int [] arr = new int[LIMIT];
        for(int i=0; i<LIMIT; i++){
            arr[i]=0;
        }
        return arr;
    }
    public static void main(String [] args){
        int carryOver=0;
        for(int k=49; k>=0 ; k-- ){
            int number=0;
            for(int i=0; i<100; i++){
                number+= INPUT[i][k];
            }
            number+=carryOver;
            carryOver = number/10;
            sum[49-k]=number%10;
        }

        boolean leadingZeroFlag=false;
        System.out.print("SUM: "+ carryOver);
        for(int i=LIMIT-1; i>=0; i--){
            if(sum[i]!=0)
                leadingZeroFlag=true;
            if(leadingZeroFlag)
                System.out.print(sum[i]);
        }
    }

}


