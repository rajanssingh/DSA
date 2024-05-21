package Leetcode.Arrays;

public class _01_Missing_Number {
    public static void main(String[] args) {
        int [] nums = new int[] {1,2,3,5};

        int n = nums.length;
        int expectedSum = n*(n+1)/2;
        int actualSum = 0;
        for(int i=0;i<n;i++){
            actualSum+= nums[i];
        }
        System.out.println("Missing number - " + (expectedSum - actualSum));
    }
}
