package Arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class _06_Two_sum {
    public static void main(String[] args) {

        int[] ans = twoSumUsingExtraSpace(new int[]{3, 2, 4}, 6);
        System.out.println("indices - " + ans[0] + ", " + ans[1]);

    }

    public static int[] twoSumQuadraticTimeComplexity(int[] nums, int target) {
        // O(n2)
        int size = nums.length;
        for (int firstIndex = 0; firstIndex < size; firstIndex++) {
            for (int secondIndex = firstIndex + 1; secondIndex < size; secondIndex++){
                if(nums[firstIndex] + nums[secondIndex] == target){
                    return new int[]{firstIndex, secondIndex};
                }
            }
        }
        return null;
    }

    public static int[] twoSumUsingExtraSpace(int [] nums, int target){
        // Time O(n) Space O(n)
        Map<Integer, Integer> map = new HashMap<>();
        int size = nums.length;
        for(int i=0;i<size;i++){
            int j = map.getOrDefault(target - nums[i], -1);
            if(j!= -1 && j!=i){
                return new int[]{i,j};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
