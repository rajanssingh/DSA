package Leetcode.Arrays;

import java.util.Arrays;

public class _17_MergeIntervals {
    public static void main(String[] args) {
        int [][] res = merge(new int[][]{{1,3},{2,6},{8,10},{15,18}});

        for(int i=0;i<res.length;i++){
            for(int j=0;j<2;j++){
                System.out.print(res[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int n = intervals.length;
        int nonOverlapping = 0;

        int[][] res = new int[n][2];
        int res_counter =0;
        for(int i=0;i<n;i++) {
            int j=i;

            if(i== n-1){
                nonOverlapping++;
                res[res_counter]= new int[]{intervals[i][0],intervals[i][1]};
                break;
            }

            while(j<n-1 && intervals[j+1][0] <= intervals[i][1]){
                j++;
            }
            if(j!=i) {
                nonOverlapping++;
                res[res_counter++] = new int[]{intervals[i][0], Integer.max(intervals[i][1],intervals[j][1])};
                i = j;
            }
            else{
                nonOverlapping++;
                res[res_counter++] = new int[]{intervals[i][0], intervals[i][1]};
            }
        }
        return Arrays.copyOfRange(res, 0, nonOverlapping);
    }
}
