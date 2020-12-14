package com.anexinet.abreutest.question4;

import com.anexinet.abreutest.utils.MatrixPrinter;

import java.util.HashSet;
import java.util.Set;

public class AnswerFour {
    private static Set<Integer> rowsToChange = new HashSet<Integer>();
    private static Set<Integer> columnsToChange = new HashSet<Integer>();
    /**
     * If an element in the matrix is 0 , its entire row and column are set to 0 and then printed out.
     * If more than zero isp present, all coincidences handled before printing
     * @param matrix an MxN matrix
     */
    public static void convertRowsAndColumnsToZero(int[][] matrix){
        for(int x=0; x< matrix.length;x++){
            for(int y=0; y<matrix[x].length; y++){
                if(matrix[x][y]==0){
                    rowsToChange.add(x);
                    columnsToChange.add(y);
                }
            }
        }
        replaceWithZero(matrix);
        MatrixPrinter.printMatrix(matrix);
    }

    /**
     * With the positions identified in the sets, numbers are replaced
     * @param matrix
     */
    private static void replaceWithZero(int[][] matrix){
        for(int x=0; x< matrix.length;x++){
            for(int y=0; y<matrix[x].length; y++){
                if(rowsToChange.contains(x)||columnsToChange.contains(y)){
                    matrix[x][y]=0;
                }
            }
        }
    }
}
