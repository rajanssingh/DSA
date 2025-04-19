package Leetcode.Arrays;

public class _16_Next_Permutation {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 4, 2};
        nextPermutation(nums);

    }

    public static void nextPermutation(int[] nums) {
        // find first dip from right
        int n = nums.length;
        int i = n - 1;

        // Find first dip from right
        while (i > 0 && nums[i] <= nums[i - 1]) {
            i--;
        }
        i--;

        if (i >= 0) {
            int j = n - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

            reverse(nums, i + 1, n - 1);
        } else {
            reverse(nums, 0, n - 1);
        }

        // Print nums
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
