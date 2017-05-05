package org.bakore;


public class Problem15 {
    private static long[] [] grid = initializeArray();
    private static final int GRID_SIZE=21;
    public static void main(String[] args){

        // Start from the bottom , use Dynamic Programming to solve this.
        // There are effectively 21X21 nodes for a grid of 20X20
        // Grid 19,19 Path is 1
        // 19,20 and 20,19 is
        // 19,19 is 2
        for(int row =GRID_SIZE-1; row>=0; row--){
            for(int col=GRID_SIZE-1; col>=0; col--){
                //Special Cases
                if(col==GRID_SIZE-1 && row==GRID_SIZE-1){
                    grid[row][col]=1;
                }
                else if(col==GRID_SIZE-1){
                    grid[row][col]= grid[row+1][col];
                }else if(row==GRID_SIZE-1){
                    grid[row][col]=grid[row][col+1];
                }else{
                    grid[row][col] = grid[row+1][col]+grid[row][col+1];
                }
            }
        }
        System.out.println("No of paths: "+ grid[0][0]);
    }

    private static long[][] initializeArray() {
        long [][] arr = new long[GRID_SIZE][GRID_SIZE];
        for(int row=0; row<GRID_SIZE; row++){
            for(int col=0; col<GRID_SIZE; col++){
                arr[row][col]=0;
            }
        }
        return arr;
    }
}
