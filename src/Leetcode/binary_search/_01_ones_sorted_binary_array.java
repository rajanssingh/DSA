package Leetcode.binary_search;

public class _01_ones_sorted_binary_array {
    public static void main(String[] args) {

        int nums[] = new int[]{0,0,0, 0,0};
        int n = nums.length;
        int firstOne = -1;
        int l=0,r=n-1;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(nums[mid] == 1){
                firstOne = mid;
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        System.out.println("Number of ones - " + (firstOne == -1 ? 0 :(n - firstOne)));

    }
}
