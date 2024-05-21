package binary_search;

public class _04_smallest_rotated_sorted_array {

    class Solution {
        public int findMin(int[] arr) {
            int n = arr.length;
            int start = 0, end = n - 1;
            if (n == 0 || n == 1) {
                return arr[0];
            }

            while (start <= end) {
                int mid = start + (end - start) / 2;

                if (arr[mid] <= arr[(mid + 1) % n] && arr[mid] <= arr[(mid - 1 + n) % n]) {
                    return arr[mid];
                }

                if (arr[mid] >= arr[0]) {
                    start = mid + 1;
                } else if (arr[mid] < arr[0]) {
                    end = mid - 1;
                }
            }
            return arr[0];
        }
    }
}
