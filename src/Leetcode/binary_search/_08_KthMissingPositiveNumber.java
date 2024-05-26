package Leetcode.binary_search;

import java.util.Arrays;

public class _08_KthMissingPositiveNumber {
    public static void main(String[] args) {
        System.out.println(findKthPositive(new int[]{2,3,4,7,11}, 5));
    }

    public static int findKthPositive(int[] arr, int k) {
        int start = 0, end = arr.length - 1;
        int ans = -1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(arr[mid] - (mid + 1) < k){
                start = mid  +1;
            }
            else {
                end = mid - 1;
            }
        }
        return start + k;
    }
}
