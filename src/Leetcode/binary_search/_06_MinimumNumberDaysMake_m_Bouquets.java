package Leetcode.binary_search;

public class _06_MinimumNumberDaysMake_m_Bouquets {
    public static void main(String[] args) {
        System.out.println(minDays(new int[]{1000000000,1000000000}, 1, 1));
    }

    public static int minDays(int[] bloomDay, int m, int k) {
        int range = 0;
        for(int i=0;i<bloomDay.length;i++){
            range = Integer.max(range, bloomDay[i]);
        }

        int minimumDays = -1;

        int start = 0, end = range;
        while(start <=end){
            int mid = start + (end - start)/2;
            // check if |mid| days if it's possible to make m bouquets with k adjacent flowers
            int cntOfBouquets = 0;
            for(int i=0;i<bloomDay.length;i++){
                if(bloomDay[i] <= mid){
                    int flowersRequired = 0;
                    while(i < bloomDay.length && bloomDay[i] <= mid){
                        flowersRequired++;
                        if(flowersRequired == k){
                            cntOfBouquets++;
                            break;
                        }
                        else{
                            i++;
                        }
                    }
                }
            }
            // m bouquets made??
            if(cntOfBouquets >= m){
                minimumDays = mid;
                end= mid - 1;
            }
            else{
                start = mid+1;
            }
        }
        return minimumDays;
    }
}
