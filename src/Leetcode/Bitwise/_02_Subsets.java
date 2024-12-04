package Leetcode.Bitwise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _02_Subsets {
    public static void main(String[] args) {

        _02_Subsets subsetsSolution = new _02_Subsets();
        List<List<Integer>> list = subsetsSolution.subsetsUsingRecursiveBacktracking(new int[]{1, 2, 3});

        for (var i : list) {
            System.out.print(i + ", ");
        }
    }

    public static List<List<Integer>> subsetsUsingIterative(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());

        for (int i : nums) {
            int size = subsets.size();
            for (int j = 0; j < size; j++) {
                List<Integer> subsetTillNow = new ArrayList<>(subsets.get(j));
                subsetTillNow.add(i);
                subsets.add(subsetTillNow);
            }
        }
        return subsets;
    }

    public List<List<Integer>> subsetsUsingRecursiveBacktracking(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generateSubsetUsingBacktracking(nums, 0, new ArrayList<>(), result);
        return result;
    }

    public void generateSubsetUsingBacktracking(int[] nums, int pos, List<Integer> currentSubset, List<List<Integer>> subsets) {

        subsets.add(new ArrayList<>(currentSubset));
        System.out.println("Current subset - " + currentSubset);
        for (int i = pos; i < nums.length; i++) {
            currentSubset.add(nums[i]);
            generateSubsetUsingBacktracking(nums, i + 1, currentSubset, subsets);
            currentSubset.remove(currentSubset.size() - 1);
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
