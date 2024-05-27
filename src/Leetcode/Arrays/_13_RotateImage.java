package Leetcode.Arrays;

public class _13_RotateImage {
    public static void main(String[] args) {
        rotate(new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}});

//        rotate(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
    }

    public static void rotate(int[][] matrix) {

        int n = matrix.length;

        // Transpose the matrix in-place
        // only swap when i>j,  lower half diagonal
        for(int i=0; i<n ;i++){
            for(int j=i+1;j<n;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // reverse each row
        for(int i=0;i<n;i++){
            for(int start=0,end=n-1;start<end;start++,end--){
                int temp = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = temp;
            }
        }

        // Rotated matrix
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(matrix[i][j] + ", ");
            }
            System.out.println();
        }


    }
}
