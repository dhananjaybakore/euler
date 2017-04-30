package org.bakore;


public class Problem9 {

    public static void main(String[] args){
        //a<b<c
        //a2 + b2 = c2
        // a+b+c =1000

        for (int a=1; a<1000; a++){
            for (int b=1; b<1000; b++){
                if(!(b>a)){
                    continue;
                }
                int c = 1000-a-b;
                if(!(c>b && c>a )){
                    continue;
                }
                if((c*c)==(a*a + b*b)){
                    int product = a* b *c;
                    System.out.println(product);
                    return;
                }
            }
        }

    }
}
