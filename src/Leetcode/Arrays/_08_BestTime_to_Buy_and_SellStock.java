package Leetcode.Arrays;

public class _08_BestTime_to_Buy_and_SellStock {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));

    }

    public static int maxProfit(int[] prices) {
        // Time - O(n)
        int maxProfit = 0;
        int n = prices.length;
        int smallestYet = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(prices[i] < smallestYet){
                smallestYet = prices[i];
            }
            maxProfit = Integer.max(maxProfit, prices[i] - smallestYet);
        }

        return maxProfit;
    }
}
