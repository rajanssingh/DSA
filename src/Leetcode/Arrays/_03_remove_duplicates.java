package Leetcode.Arrays;

public class _03_remove_duplicates {
    public static void main(String[] args) {
        int nums[] = new int[]{1,1,1,2,2,3,4,4,5,99,99,100,100,100};

        int k = removeDuplicates(nums);
        System.out.println(k);
        for(int i=0;i<k;i++){
            System.out.print(nums[i] + " ");
        }

    }

    public static int removeDuplicates(int[] nums) {
        int numOfUniqueItems = -1;
        int n = nums.length;
        for(int i=0;i<n;){
            numOfUniqueItems++;
            int currentElement = nums[i];
            nums[numOfUniqueItems] = currentElement;
            while(i< n && nums[i] == currentElement){
                i++;
            }
        }
        return numOfUniqueItems+1;

    }
}
