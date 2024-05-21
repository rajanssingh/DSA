package Leetcode.binary_search;

public class _03_No_rotation_sorted_array {
    public static void main(String[] args) {
        int[] arr = new int[]{3,4,5,1,2};
        System.out.println("Number of rotations = " + countNumberOfRotations(arr));
    }

    public static Integer countNumberOfRotations(int[] arr) {
        int n = arr.length;
        int start = 0, end = n - 1;
        if (n == 0 || n == 1) {
            return 0;
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] <= arr[(mid + 1) % n] && arr[mid] <= arr[(mid - 1 + n) % n]) {
                return mid;
            }

            if (arr[mid] >= arr[0]) {
                start = mid + 1;
            } else if (arr[mid] < arr[0]) {
                end = mid - 1;
            }
        }
        return 0;
    }
}
