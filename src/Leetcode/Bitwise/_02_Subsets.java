package Leetcode.Bitwise;

import java.util.ArrayList;
import java.util.List;

public class _02_Subsets {
    public static void main(String[] args) {
        List<List<Integer>> list = subsets(new int[]{1,2,3});

        for (var i : list) {
            System.out.println(i + ", ");
        }
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();

        int n = nums.length;
        int numberOfSubsets = (int) Math.pow(2, n);
        for (int set = 0; set < numberOfSubsets; set++) {
            List<Integer> currentSubset = new ArrayList<>();
            for (int pos = 0; pos < n; pos++) {
                if (((1 << pos) & set) != 0) {
                    currentSubset.add(nums[pos]);
                }
            }
            subsets.add(currentSubset);
        }
        return subsets;
    }
}
