package org.bakore;

public class Problem17 {

    private static int [] numberLetterCount = initializeEmptyArray();
    private static final int ARR_SIZE=1001;
    private static final int HUNDRED = 7, AND=3;

    static {
        //One
        numberLetterCount[1]=3;
        //Two
        numberLetterCount[2]=3;
        //Three
        numberLetterCount[3]=5;
        //Four
        numberLetterCount[4]=4;
        //Five
        numberLetterCount[5]=4;
        //Six
        numberLetterCount[6]=3;
        //Seven
        numberLetterCount[7]=5;
        //Eight
        numberLetterCount[8]=5;
        //Nine
        numberLetterCount[9]=4;
        //Ten
        numberLetterCount[10]=3;
        //Eleven
        numberLetterCount[11]=6;
        //Twelve
        numberLetterCount[12]=6;
        //Thirteen
        numberLetterCount[13]=8;
        //Fourteen
        numberLetterCount[14]=8;
        //Fifteen
        numberLetterCount[15]=7;
        //Sixteen
        numberLetterCount[16]=7;
        //Seventeen
        numberLetterCount[17]=9;
        //Eighteen
        numberLetterCount[18]=8;

        //Nineteen
        numberLetterCount[19]=8;
        //Twenty
        numberLetterCount[20]=6;

        //Thirty
        numberLetterCount[30]=6;
        //Forty
        numberLetterCount[40]=5;
        //Fifty
        numberLetterCount[50]=5;
        //Sixty
        numberLetterCount[60]=5;
        //Seventy
        numberLetterCount[70]=7;
        //Eighty
        numberLetterCount[80]=6;
        //Ninety
        numberLetterCount[90]=6;

        //Nine Hundred and Ninety Nine
        //One Thousand
        numberLetterCount[1000]=11;

    }
    public static void main(String [] args){
        for(int i=21; i<1000; i++){
            //Skip all which are pre-calculated
            if((i/10<10 && i%10==0)){
                //System.out.println("Skipped as already calculated: "+i);
                continue;
            }
            if(i/10<10){
                int lastDigit = i%10;
                numberLetterCount[i]= numberLetterCount[i-lastDigit]+ numberLetterCount[lastDigit];
            }else if(i%100==0){
                numberLetterCount[i]= numberLetterCount[i/100]+HUNDRED;
            }
            else{
                numberLetterCount[i] = numberLetterCount[i/100]+ HUNDRED+ AND+ numberLetterCount[i%100];
            }
           // System.out.println("Number: "+ i+" Length: "+ numberLetterCount[i]);
        }
        int sum = 0;
        for(int i=1; i<=1000; i++){
            sum+= numberLetterCount[i];
        }
        System.out.println("Answer: "+ sum);
    }

    private static int[] initializeEmptyArray() {
        int [] arr = new int[ARR_SIZE];
        for(int i=0; i<ARR_SIZE; i++){
            arr[i]=0;
        }
        return arr;
    }
}
