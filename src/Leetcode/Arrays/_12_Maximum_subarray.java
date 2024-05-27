package Leetcode.Arrays;

public class _12_Maximum_subarray {
    public static void main(String[] args) {
        System.out.println(maxSubArrayAnother(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));

    }

    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        int cur_max = nums[0];
        int global_max = nums[0];

        for (int i = 1; i < n; i++) {
            cur_max = Integer.max(nums[i], cur_max + nums[i]);
            global_max = Integer.max(global_max, cur_max);
        }
        return global_max;
    }

    public static int maxSubArrayAnother(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        return maxSubArrayUsingDivideAndConquer(nums, 0, nums.length - 1);
    }

    public static int maxSubArrayUsingDivideAndConquer(int[] nums, int low, int high) {
        // Base case
        if (low == high) {
            return nums[low];
        }

        int mid = low + (high - low) / 2;

        // find maximum subArray to left and right of mid
        int maxLeft = Integer.MIN_VALUE;
        int maxRight = Integer.MIN_VALUE;
        int sum = 0;
        // left
        for (int i = mid; i >= low; i--) {
            sum += nums[i];
            maxLeft = Integer.max(maxLeft, sum);
        }
        sum = 0;
        // right
        for (int i = mid + 1; i <= high; i++) {
            sum += nums[i];
            maxRight = Integer.max(maxRight, sum);
        }


        // Recursively find the maximum subArray sum in left and right halves
        int leftMaxSubArray = maxSubArrayUsingDivideAndConquer(nums, low, mid);
        int rightMaxSubArray = maxSubArrayUsingDivideAndConquer(nums, mid + 1, high);

        return Integer.max(Integer.max(leftMaxSubArray, rightMaxSubArray), maxLeft + maxRight);

    }
}
