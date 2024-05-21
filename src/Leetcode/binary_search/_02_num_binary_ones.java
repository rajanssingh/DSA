package Leetcode.binary_search;

public class _02_num_binary_ones {
    public static void main(String[] args) {
        int n = 0;
        int countNumOnes = 0;
        while(n >0){
            if((n & 1) ==1){
                countNumOnes++;
            }
            n >>=1;
        }
        System.out.println("Number of ones - "+ countNumOnes);
    }
}
