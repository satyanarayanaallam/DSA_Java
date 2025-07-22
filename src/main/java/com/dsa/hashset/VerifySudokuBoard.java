package com.dsa.hashset;

import java.util.HashSet;

public class VerifySudokuBoard {
    public static void main(String args[]){

    }
    private static boolean verifySudokuBoard(int[][] sudoku){
       if(sudoku==null || sudoku.length!=9 || sudoku[0].length!=9 ) return false;
       HashSet<Integer>[] rowSets= new HashSet[9];
       HashSet<Integer>[] colSets= new HashSet[9];
       HashSet<Integer>[][] subGridSets= new HashSet[3][3];
        for (int i = 0; i < 9; i++) {
            rowSets[i] = new HashSet<>();
            colSets[i] = new HashSet<>();
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                subGridSets[i][j] = new HashSet<>();
            }
        }
       for(int i=0;i<sudoku.length;i++){
           for(int j=0;j<sudoku[0].length;j++){
               int num = sudoku[i][j];
               if (num < 1 || num > 9) return false;
               if(rowSets[i].contains(num)) return false;
               if(colSets[j].contains(num)) return false;
               if(subGridSets[i/3][j/3].contains(num)) return false;
               rowSets[i].add(num);
               colSets[j].add(num);
               subGridSets[i/3][j/3].add(num);
           }
       }
       return true;
    }
}
