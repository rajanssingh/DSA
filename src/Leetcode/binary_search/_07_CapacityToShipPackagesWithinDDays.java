package Leetcode.binary_search;

public class _07_CapacityToShipPackagesWithinDDays {
    public static void main(String[] args) {
        System.out.println(shipWithinDays(new int[]{1,2,3,1,1}, 4));
    }

    public static int shipWithinDays(int[] weights, int days) {
        int maxRange = 0;
        for(int i:weights){
            maxRange += i;
        }

        int start = 0, end = maxRange;
        int minimumWeight = Integer.MAX_VALUE;
        while(start <= end){
            int mid = start + (end-start)/2;
            int numOfDays = 0;
            for(int i=0;i<weights.length;){
                int cur_sum = 0;
                while(i < weights.length && cur_sum <= mid){
                    cur_sum += weights[i];
                    if(cur_sum > mid){
                        break;
                    }
                    i++;
                }
                numOfDays ++;

                if(numOfDays > days){
                    break;
                }
            }

            if(numOfDays <= days){
                minimumWeight = mid;
                end = mid-1;
            }
            else{
                start = mid+1;
            }

        }

        return minimumWeight;
    }
}

