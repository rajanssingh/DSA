package Leetcode.Arrays;

import java.util.ArrayList;
import java.util.List;

public class _15_Pascals_triangle {
    public static void main(String[] args) {
        int rows = 5;

        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<rows;i++){
            list.add(new ArrayList<>());
        }

        for(int i=0;i<rows;i++){
            for(int j=0;j<=i;j++){
                if(j==0 || j==i){
                    list.get(i).add(1);
                }
                else{
                    list.get(i).add(list.get(i-1).get(j-1) + list.get(i-1).get(j));
                }
            }
        }

        for(int i=0;i<rows;i++){
            for(int j=0;j<=i;j++){
                System.out.print(list.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
}
