package Leetcode.Bitwise;

public class _01_Minimum_BitFlips_toConvertNumber {
    public static void main(String[] args) {
        minBitFlips(10, 7);
    }
    public static int minBitFlips(int start, int goal) {
        int num = start ^ goal;
        int cnt = 0;
        while(num > 0){
            if((num & 1) == 1){
                cnt++;
            }
            num >>= 1;
        }
        return cnt;
    }
}
