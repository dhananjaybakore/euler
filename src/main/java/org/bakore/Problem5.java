package org.bakore;



public class Problem5 {

     private static final int LIMIT=21;

    public static void main(String [] args){
        int [] primeFactorMap = initializeEmptyArray();
        for(int i=2; i<LIMIT; i++){
            merge(primeFactorMap,primeFactors(i));

        }
        int answer = 1;
        for(int i=2; i<LIMIT ; i++){
            if(primeFactorMap[i]!=0){
                for(int k=0; k<primeFactorMap[i]; k++){
                    answer = answer * i;
                }
            }
        }
        System.out.println(answer);

    }

    private static void merge(int[] primeFactorMap, int[] primeFactorMap2) {
        //Both will have same size
        for(int i=0; i<LIMIT; i++){
            if(primeFactorMap[i]<primeFactorMap2[i])
                primeFactorMap[i]=primeFactorMap2[i];
        }
    }


    private static int[] primeFactors(int number){
        int[] primeFactors = initializeEmptyArray();
        while(number%2==0){
            number = number /2;
            primeFactors[2]++;
        }
        // we have removed all factors of 2 so now there are only odd numbers
        for(int i=3; i<=Math.sqrt(number); i+=2){
            while(number%i==0){
                number = number/i;
                primeFactors[i]++;
            }
        }
        //if number is a prime number greater than 2?
        if(number>2){
            primeFactors[number]++;
        }
        return primeFactors;
    }

    private static int[] initializeEmptyArray() {
        int [] arr = new int[LIMIT];
        for(int i=0; i<LIMIT; i++){
            arr[i]=0;
        }
        return arr;
    }


//    private static List<Integer> primeFactors(int number){
//        List<Integer> primarFactors = new ArrayList<Integer>();
//        while(number%2==0){
//            number = number /2;
//            primarFactors.add(2);
//        }
//
//        // we have removed all factors of 2 so now there are only odd numbers
//        for(int i=3; i<=Math.sqrt(number); i+=2){
//            while(number%i==0){
//                number = number/i;
//                primarFactors.add(i);
//            }
//        }
//
//        //if number is a prime number greater than 2?
//        if(number>2){
//            primarFactors.add(number);
//        }
//        return primarFactors;
//    }
}
