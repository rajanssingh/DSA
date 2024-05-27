package Leetcode.Arrays;

import java.util.Arrays;

public class _10_Majority_Element {

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{2,2,1,1,1,2,2}));
    }

    public static int majorityElementUsingSort(int[] nums) {
        Arrays.sort(nums);

        for(int i=0;i<nums.length;){
            int cnt = 0;
            int cur_element = nums[i];
            while(i < nums.length && nums[i] == cur_element){
                cnt++;
                i++;
            }
            if(cnt > nums.length/2){
                return cur_element;
            }
        }
        return -1;
    }

    public static int majorityElement(int[] nums){
        int n = nums.length;
        int majorityElement = 0;
        for(int pos=0;pos<32;pos++){
            int bitMask = 1 << pos;
            int bitCount = 0;
            for(int i=0;i<n;i++){
                if((nums[i] & bitMask) != 0){
                    bitCount++;
                }
            }
            if(bitCount > n/2){
                majorityElement |= bitMask;
            }
        }
        return majorityElement;
    }

    public static int majorityElementUsingMoore(int [] nums){
        int n = nums.length;

        int candidate = nums[0];
        int count = 1;

        for(int i=1;i<n;i++){
            if(nums[i] == candidate){
                count++;
            }
            else{
                count--;
                if(count == 0){
                    count = 1;
                    candidate = nums[i];
                }
            }
        }

        // We need one more iteration to verify whether candidate is the majority element, if this fails then there is no majority element
        count = 0;
        for(int i:nums){
            if(i == candidate){
                count++;
            }
        }

        if(count > n/2){
            return candidate;
        }
        else {
            return -1;
        }
    }
}
