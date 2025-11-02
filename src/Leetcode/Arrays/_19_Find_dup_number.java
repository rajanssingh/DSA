package Leetcode.Arrays;

public class _19_Find_dup_number {
    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};
        /*
        Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
        There is only one repeated number in nums, return this repeated number.
        You must solve the problem without modifying the array nums and using only constant extra space.
         */

        /**
         * O(n2), no extra space --> did not take any advantage of numbers range [1,n]
         * Give TLE
         */
/*        int n = nums.length;
        int dup = nums[0];
        for(int i=0;i<n-1;i++){
            int cur_dup = nums[i];
            for(int j=i+1;j<n;j++){
                if(nums[j]==cur_dup){
                    dup=nums[j];
                    break;
                }
            }
        }*/

        /**
         * Approach 2 :
         * No extra space
         */
    }
}
