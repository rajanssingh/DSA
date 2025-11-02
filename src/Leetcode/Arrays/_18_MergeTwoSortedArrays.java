package Leetcode.Arrays;

import java.util.Arrays;

public class _18_MergeTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 4, 5, 6};
        int n = 4;

        // Merge and final array in nums1
        // Fill array right to left

        int t = m + n - 1;
        int i = m - 1;
        int j = n - 1;

        if (m == 0) {
            nums1 = nums2;
        }

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[t--] = nums1[i--];
            } else if (nums1[i] < nums2[j]) {
                nums1[t--] = nums2[j--];
            } else {
                nums1[t--] = nums1[i--];
                nums1[t--] = nums2[j--];
            }

            if (i < 0 && j >= 0) {
                while (j >= 0) {
                    nums1[t--] = nums2[j--];
                }
            }
        }

        Arrays.stream(nums1).forEach(r -> System.out.print(r + " "));
    }
}
