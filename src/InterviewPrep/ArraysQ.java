package InterviewPrep;


public class ArraysQ {
    public static void main(String[] args) {
/*
        EASY
        Given an array arr[] containing 2*N+2 positive numbers, out of which 2*N numbers exist in pairs whereas the
         other two number occur exactly once and are distinct. Find the other two numbers. Return in increasing order.

        Example:

        Input: N = 2, arr[] = {1, 2, 3, 2, 1, 4}
        Output:3 4
        Explanation: 3 and 4 occur exactly once.

                Input: N = 1, arr[] = {2, 1, 3, 2}
        Output: 1 3
        Explanation: 1 3 occur exactly once.
*/
        solve(new int[]{2,1,3,2});
    }

    public static void solve(int [] nums){
        int pairXor = 0;
        for(int i: nums){
            pairXor ^= i;
        }

        System.out.println(Integer.toBinaryString(pairXor));
        System.out.println(pairXor & (-1 * pairXor));


        int num1 = 0, num2 = 0;

        int setBitPlace = 0;
        while(pairXor > 0){
            if((pairXor & 1) == 1){
                break;
            }
            else {
                pairXor = pairXor >> 1;
                setBitPlace ++;
            }
        }
        System.out.println(setBitPlace);

        // Divide into two groups

        for(int i: nums){
            if((i & ( 1 << setBitPlace)) != 0){
                num1 ^= i;
            }
            else{
                num2 ^= i;
            }
        }
        System.out.println("two numbers are " + num1 + " -- " + num2);
    }
}
