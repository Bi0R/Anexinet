package com.anexinet.abreutest.utils;

public class MatrixPrinter {
    public static void printMatrix(int[][] matrix){
        for(int x=0; x< matrix.length;x++){
            for(int y=0; y<matrix[x].length; y++){
                System.out.print(matrix[x][y]+" ");
            }
            System.out.print("\n");
        }
    }
}
