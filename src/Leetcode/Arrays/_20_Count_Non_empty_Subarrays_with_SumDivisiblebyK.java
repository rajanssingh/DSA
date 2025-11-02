package Leetcode.Arrays;

import java.util.HashMap;
import java.util.Map;

public class _20_Count_Non_empty_Subarrays_with_SumDivisiblebyK {
    public static void main(String args[]) {
        System.out.println(
                subarraysDivByK(new int[]{-1,2,9}, 2)
        );
    }

    public static int subarraysDivByK(int[] nums, int k) {
        // Idea: Prefix sum array and then %k
        // If prefix % k  repeats --> subarray sum divisible by k

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        frequencyMap.put(0, 1);

        int result = 0;
        int p_sum = 0;
        for(int i: nums){
            p_sum += i;
            int mod = (p_sum % k + k) % k;
            result += frequencyMap.getOrDefault(mod, 0);
            frequencyMap.put(mod, frequencyMap.getOrDefault(mod, 0) + 1);
        }
        return result;
    }
}
