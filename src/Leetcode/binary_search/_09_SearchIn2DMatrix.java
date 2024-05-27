package Leetcode.binary_search;

public class _09_SearchIn2DMatrix {
    public static void main(String[] args) {
        System.out.println(searchMatrixAnother(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 3));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int size = row * col;

        int start = 0 ,end = size - 1;
        while(start <= end){
            int mid = start + (end - start)/2;
            int i = mid / col;
            int j = mid % col;

            if(matrix[i][j] == target){
                return true;
            }
            else if(matrix[i][j] > target){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return false;
    }

    public static boolean searchMatrixAnother(int[][] matrix, int target) {
        int rowSize = matrix.length;
        int colSize = matrix[0].length;

        int row = 0, col = colSize-1;
        while(row < rowSize && col>=0){
            if(matrix[row][col] == target){
                return true;
            } else if (target > matrix[row][col]) {
                row++;
            }
            else {
                col--;
            }
        }
        return false;
    }

}
