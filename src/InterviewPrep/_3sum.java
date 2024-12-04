package InterviewPrep;

import java.util.*;

public class _3sum {
    public static void main(String[] args) {
        List<List<Integer>> result = threeSumUsingHashMap(new int[]{-1,0,1,2,-1,-4});
        result.forEach(System.out::println);
    }

    public static List<List<Integer>> threeSumUsingHashMap(int[] nums) {
        Set<List<Integer>> resultSet = new HashSet<>();
        int length = nums.length;
        for(int i=0; i<length; i++){
            int target = -1 * nums[i];
            Map<Integer, Integer> map = new HashMap<>();
            for(int j=i+1; j<length;j++){
                int complement = target - nums[j];
                if(map.containsKey(complement)){
                    List<Integer> triplet = Arrays.asList(nums[i], nums[j], complement);
                    Collections.sort(triplet);
                    resultSet.add(triplet);
                }
                map.put(nums[j], j);
            }
        }

        return new ArrayList<>(resultSet);
    }

    public static List<List<Integer>> threeSumUsingTwoPointers(int [] nums){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0; i<n-2;i++){
            if(i==0 || (i > 0 && nums[i] != nums[i-1])) {
                int target = -1 * nums[i];
                int low = i + 1, high = nums.length - 1;

                while (low < high) {
                    int sum = nums[low] + nums[high];
                    if (sum == target) {
                        result.add(List.of(nums[i], nums[low], nums[high]));
                        while(low < high && nums[low] == nums[low+1]) low++;
                        while(low < high && nums[high] == nums[high-1]) high--;
                        low++;
                        high--;
                    } else if (sum < target) {
                        low++;
                    } else {
                        high--;
                    }
                }
            }
        }
        return result;

    }

}
