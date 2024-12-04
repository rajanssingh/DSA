package Leetcode.Arrays;

import java.util.PriorityQueue;

public class _14_First_Missing_Positive {
    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{7,8,9,11,12}));
    }

    public static int firstMissingPositive(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i: nums){
            if(i > 0){
                pq.add(i);
            }
        }
        if(pq.peek() > 1){
            return pq.peek() - 1;
        }
        Integer curMin = pq.poll();
        while(curMin != null && pq.peek() != curMin+1){
            curMin=pq.poll();
        }
        if(pq.isEmpty()){
            return curMin+1;
        }
        return pq.peek()+1;

    }
}
