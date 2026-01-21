package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q1 {
    /**
     * <a href="https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/">
     * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/</a>
     */

    class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            int n = nums.length;
            List<Integer> res = new ArrayList<>();

            for(int i=0; i<n; i++){
                int index = Math.abs(nums[i]) - 1;
                if(nums[index] > 0){
                    nums[index] *= -1;
                }
            }

            for(int i=0; i<n; i++){
                if(nums[i] > 0){
                    res.add(i+1);
                }
            }

            return res;
        }
    }
}
