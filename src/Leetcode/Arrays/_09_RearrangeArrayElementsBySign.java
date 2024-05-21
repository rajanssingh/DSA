package Leetcode.Arrays;

public class _09_RearrangeArrayElementsBySign {

    public static void main(String[] args) {
        int [] ans = rearrangeArrayUsingExtraSpace(new int[]{3,1,-2,-5,2,-4});
        for(int i:ans){
            System.out.print(i + " ");
        }

    }
    public static int[] rearrangeArrayUsingExtraSpace(int[] nums) {
        // even pos - positive, odd pos - negative
        int n= nums.length;
        int [] rearrangedArray = new int[n];
        int pos = 0,neg = 1;

        for(int i=0;i<n;i++){
            if(nums[i] > 0){
                rearrangedArray[pos] = nums[i];
                pos += 2;
            }
            else{
                rearrangedArray[neg] = nums[i];
                neg+= 2;
            }
        }

        return rearrangedArray;
    }
}
