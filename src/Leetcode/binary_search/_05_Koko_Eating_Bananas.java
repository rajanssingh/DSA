package Leetcode.binary_search;

public class _05_Koko_Eating_Bananas {
    public static void main(String[] args) {

        System.out.println(minEatingSpeed(new int[]{805306368,805306368,805306368}, 1000000000));
    }

    public  static  int minEatingSpeed(int[] piles, int h) {
        int minSpeed = Integer.MAX_VALUE;

        int end = 0;
        for(int i: piles) {
            end = Integer.max(i, end);
        }
        int start = 1;

        while(start <= end){
            int mid = start + (end-start)/2;

            int hours = 0;
            for(int i=0;i<piles.length;i++){
                hours+= Math.ceil((double) piles[i]/mid);
            }

            if(hours <= h && mid < minSpeed){
                minSpeed = mid;
            }
            else if(hours > h){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }

        return minSpeed;

    }
}
