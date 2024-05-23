package Leetcode.Arrays;

import java.util.Arrays;
import java.util.Collections;

public class _11_Set_MatrixZeroes {
    public static void main(String[] args) {
        setZeroesNoSpace(new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}});
    }

    public static void setZeroesWithExtraSpace(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int [][] matrix2 = new int[r][c];

        // Does not work for 2d array
//        Arrays.fill(matrix2, Integer.valueOf(1));
//        Integer[][] array = Collections.nCopies(r * c, 1).stream().toArray(Integer[][]::new);


        //set all elements of new matrix to one
        Arrays.stream(matrix2).forEach(row -> Arrays.fill(row, 1));

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(matrix[i][j] == 0){
                    for(int col=0;col<c;col++){
                        matrix2[i][col] = 0;
                    }
                    for(int row=0;row<r;row++){
                        matrix2[row][j] = 0;
                    }
                }
            }
        }

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(matrix2[i][j]== 0){
                    matrix[i][j] = 0;
                }
            }
        }

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                System.out.print(matrix[i][j] + ", ");
            }
            System.out.println();
        }
    }

    public static void setZeroesAnother(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int []row = new int[r];
        int []col = new int[c];

        Arrays.fill(row, 0);
        Arrays.fill(col, 0);

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(matrix[i][j] == 0){
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        // Rows
        for(int i=0;i<r;i++){
            if(row[i] == 1){
                for(int j=0;j<c;j++){
                    matrix[i][j] = 0;
                }
            }
        }

        // Cols
        for(int j=0;j<c;j++){
            if(col[j] == 1){
                for(int i=0;i<r;i++){
                    matrix[i][j] = 0;
                }
            }
        }

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                System.out.print(matrix[i][j] + ", ");
            }
            System.out.println();
        }
    }

    public static void setZeroesNoSpace(int[][] matrix){
        int row = matrix.length;
        int col = matrix[0].length;

        int col1Flag = 0;

        for(int i=0;i<row;i++){
            if(matrix[i][0] == 0){
                col1Flag = 1;
            }

            for(int j=1;j<col;j++){
                if(matrix[i][j] == 0){
                    matrix[0][j] = matrix[i][0] = 0;
                }
            }
        }

        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                if(matrix[0][j] == 0 || matrix[i][0] == 0){
                    matrix[i][j] = 0;
               }
            }
        }

        if(col1Flag == 1){
            for(int i=0;i<row;i++){
                matrix[i][0] = 0;
            }
        }
        if(matrix[0][0] == 0){
            for(int j=0;j<col;j++){
                matrix[0][j] = 0;
            }
        }

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }
}
