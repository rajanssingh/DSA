package Leetcode.DP;

import java.lang.reflect.Array;
import java.util.Arrays;

public class _01_CoinChange {
    public static void main(String[] args) {
        int [] coins = {1,2,5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));
    }

    public static int coinChange(int[] coins, int amount) {
        // Minimum number of coins to make amount
        int n = coins.length;

        int [] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i=1; i<=amount; i++){
            for(int j: coins){
                if(j <= i && dp[i-j] != Integer.MAX_VALUE){
                    dp[i] = Integer.min(dp[i], 1 + dp[i - j]);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
