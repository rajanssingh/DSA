package Arrays;

import java.util.ArrayList;
import java.util.List;

public class _04_spriral_matrix {

    public static void main(String[] args) {

        int [][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> result = spiralOrder(matrix);
        for(Integer i : result){
            System.out.print(i + " ");
        }

    }

    public static List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> matrixPrintList = new ArrayList<>();

        int rowSize = matrix.length;
        int colSize = matrix[0].length;

        int matrixSize = rowSize * colSize;

        int rowStart = 0, colStart=0;
        int rowEnd = rowSize-1, colEnd = colSize-1;

        while(rowStart <= rowEnd && colStart <= colEnd){
            // rowStart
            for(int j=colStart; j<=colEnd; j++){
                matrixPrintList.add(matrix[rowStart][j]);
            }
            rowStart++;

            // colEnd
            for(int i=rowStart;i<=rowEnd;i++){
                matrixPrintList.add(matrix[i][colEnd]);
            }
            colEnd--;

            // rowEnd
            for(int j=colEnd;j>=colStart;j--){
                matrixPrintList.add(matrix[rowEnd][j]);
            }
            rowEnd--;

            // colStart
            for(int i=rowEnd;i>=rowStart;i--){
                matrixPrintList.add(matrix[i][colStart]);
            }
            colStart++;

        }

        return matrixPrintList.subList(0, matrixSize);

    }
}
