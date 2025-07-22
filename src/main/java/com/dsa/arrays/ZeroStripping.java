package com.dsa.arrays;

import java.util.Arrays;

public class ZeroStripping {
    public static void main(String args[]){
        int[][] matrix = {
                {1, 2, 3},
                {4, 0, 6},
                {7, 8, 9}
        };

        zeroStripping(matrix);

        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
    private static void zeroStripping(int[][] matrix){
        if(matrix==null) return ;
        int m= matrix.length;
        int n=matrix[0].length;
        boolean firstRowHasZero = false;
        boolean firstColHasZero = false;
        for(int j=0;j<n;j++){
            if(matrix[0][j]==0)
            {
                firstRowHasZero=true;
                break;
            }
        }
        for(int i=0;i<m;i++){
            if(matrix[i][0]==0)
            {
                firstColHasZero=true;
                break;
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    matrix[0][j]=0;
                    matrix[i][0]=0;
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[0][j]==0 || matrix[i][0]==0 ){
                    matrix[i][j]=0;
                }
            }
        }
        if(firstRowHasZero){
            for(int j=0;j<n;j++){
                matrix[0][j]=0;
            }
        }
        if(firstColHasZero){
            for(int i=0;i<m;i++){
                matrix[i][0]=0;
            }
        }
    }
}
