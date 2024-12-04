package EOPINJ;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.LongStream;

/**
 * This class contains all problems related to primitive types in Java.
 * Problems are ranked according to importance.
 */
public class _01_PrimitiveTypes {

    static int[] parityCached = new int[(int) Math.pow(2, 16)];

    static long[] reverseBitsCached = new long[(int) Math.pow(2, 16)];

    @Test
    @DisplayName("01_How would you compute the parity of a very large number of 64-bit words")
    void parityOfLargeNumber() {
        Long n = 1000021599985554151L;
        // 1. Time complexity - O(w), w is word size
        System.out.println(String.format("Parity of %d = %d", n, parityBruteForce(n)));

        // 2. Can be optimized to O(k), where k is number of set bits
        System.out.println(String.format("Parity of %d = %d", n, parityBasedOnClearingSetBit(n)));

        // Even with this, when considering a large number of numbers is large it is inefficient
        // When you have to perform a large number of parity computations, and more generally any kind of bit fiddling computations, two keys to performance are -
        // a. Processing multiple bits at a time    b. Caching results in an array-based lookup table.

        // 3. Caching the results
        // We cannot cache every 64 bit num --> billions of GB
        // L - width of word, n - word size T(n) = O(n/L) (does not include time for initialization of the lookup table)
        // All right / left shift & bitwise &, |, ~ etc operations are word level operations which are done extremely efficiently by CPU.
        // Hence their time complexity is supposed to be O(1).
        preComputeParity();
        System.out.println(String.format("Parity of %d = %d", n, parityBasedOnCaching(n)));

        //4. Using XOR and Shifting operations
        // T(n) = O(logn) where n is the word size
        System.out.println(String.format("Parity of %d = %d", n, parityBasedOnXOR(n)));

        //Comparing time taken for all four methods
        long start1 = System.nanoTime();
        LongStream.range(0, 1000000).forEach(val -> parityBruteForce(val));
        long end1 = System.nanoTime();
        System.out.println("1. Time taken by Brute Force - (ms) " + (end1 - start1) / 1000000);

        long start2 = System.nanoTime();
        LongStream.range(0, 1000000).forEach(val -> parityBasedOnClearingSetBit(val));
        long end2 = System.nanoTime();
        System.out.println("2. Time taken by Clearing set bit - (ms) " + (end2 - start2) / 1000000);

        long start3 = System.nanoTime();
        LongStream.range(0, 1000000).forEach(val -> parityBasedOnCaching(val));
        long end3 = System.nanoTime();
        System.out.println("3. Time taken by Caching - (ms) " + (end3 - start3) / 1000000);

        long start4 = System.nanoTime();
        LongStream.range(0, 1000000).forEach(val -> parityBasedOnXOR(val));
        long end4 = System.nanoTime();
        System.out.println("4. Time taken by XOR - (ms) " + (end4 - start4) / 1000000);
    }

    @Test
    @DisplayName("02_WAP to take as input a 64-bit integer and swap the bits at indices i and j")
    void swapBits() {
        long n = 51; // 110011
        int i = 0, j = 2; // 110110
        long afterSwapBit = swapBits(n, i, j);
        System.out.println(String.format("%d after swapping bits at indices {%d,%d} becomes %d", n, i, j, afterSwapBit));
        System.out.println(String.format("Before - %s \nAfter - %s", Long.toBinaryString(n), Long.toBinaryString(afterSwapBit)));
    }

    @Test
    @DisplayName("03_Reverse the bits of a long number")
    void reverseBits() {
        long n = 75; // 1001011
        // Reversed - 1101001 - 105
        preComputeReverse();
        // T(n) = O(n/L) - n bit integers and L-bit cache keys
        System.out.println(String.format("%d after reversing bits - %d", n, reverseBits(n)));
        System.out.println("Before reverse - " + Long.toBinaryString(n));
        System.out.println("After reverse - " + Long.toBinaryString(reverseBits(n)));
    }

    @Test
    @DisplayName("04_WAP which takes a non negative integer x and returns a number y!= x but has the same weight and |y-x| is as small as possible")
    void closestIntegerWithSameWeight() {
        //Weight of a num - number of bits set to 1 in its binary representation
        long n = 125;
        // TODO
    }

    private void preComputeReverse() {
        int length = reverseBitsCached.length;
        for (int i = 0; i < length - 1; i++) {
            reverseBitsCached[i] = reverseBitsBruteForce(i);
        }
    }

    private long reverseBitsBruteForce(long x) {
        for (int i = 0, j = 15; i < j; i++, j--) {
            x = (int) swapBits(x, i, j);
        }
        return x;
    }

    private long reverseBits(long n) {
        final int WORD_SIZE = 16;
        final int BIT_MASK = 0xFFFF;

        return reverseBitsCached[(int) (n & BIT_MASK)] << (3 * WORD_SIZE)
                | reverseBitsCached[(int) ((n >>> WORD_SIZE) & BIT_MASK)] << (2 * WORD_SIZE)
                | reverseBitsCached[(int) ((n >>> (2 * WORD_SIZE)) & BIT_MASK)] << (WORD_SIZE)
                | reverseBitsCached[(int) ((n >>> (3 * WORD_SIZE)) & BIT_MASK)];
    }

    private long swapBits(long n, int i, int j) {
        // First see if bits at ith and jth index differ
        if (((n >>> i) & 1) != ((n >>> j) & 1)) {
            long bitMask = (1L << i) | (1L << j);
            n ^= bitMask;
        }
        return n;
    }

    private short parityBasedOnXOR(long n) {
        n ^= n >>> 32;
        // Can use cache table from here
        n ^= n >>> 16;
        n ^= n >>> 8;
        n ^= n >>> 4;
        n ^= n >>> 2;
        n ^= n >>> 1;

        return (short) (n & 1);
    }

    private void preComputeParity() {
        int length = parityCached.length;
        for (int i = 0; i < length - 1; i++) {
            parityCached[i] = parityBasedOnClearingSetBit(i);
        }
    }

    private short parityBasedOnCaching(long n) {
        /**
         * 64 bits will lead us to have Math.pow(2, 64) possible signed numbers (the most significant bit is used to store only sign). The size of a long type number is 64 bits or 8 bytes, so total memory size required is: 64 * Math.pow(2, 64) bits or 134217728 TeraBytes
         * If we store those 16 bit numbers as an integer, total memory required is: Math.pow(2, 16) * 32 bits = 256 Kilo Bytes
         */


        // Divide 64 bit num into 4 16 bit groups ; Parity computation is associative
        // 2^16 = 65536 relatively small -- can be cached using an array
        final int WORD_SIZE = 16;
        final int BIT_MASK = 0xFFFF;

        return (short) (
                parityCached[(int) ((n >>> (3 * WORD_SIZE)) & BIT_MASK)]
                        ^ parityCached[(int) ((n >>> (2 * WORD_SIZE)) & BIT_MASK)]
                        ^ parityCached[(int) ((n >>> WORD_SIZE) & BIT_MASK)]
                        ^ parityCached[(int) (n & BIT_MASK)]);

    }

    private short parityBasedOnClearingSetBit(long n) {
        short result = 0;
        while (n != 0) {
            result ^= 1;
            n &= n - 1; // Drops the lowest set bit of n
        }
        return result;
    }

    private short parityBruteForce(long n) {
        /**
         * In C/C++ there is only one right shift operator ‘>>’ which should be used only for positive integers or unsigned integers.
         * Use of the right shift operator for negative numbers is not recommended in C/C++,
         * and when used for negative numbers, the output is compiler dependent.
         * Unlike C++, Java supports following two right shift operators.
         * Signed right shift “>>” -
         * The operator ‘>>’ uses the sign bit (leftmost bit) to fill the trailing positions after the shift.
         * If the number is negative, then 1 and if the number is positive, then 0 is used as a filler.
         *
         * Unsigned right shift “>>>” -
         * In Java, the operator ‘>>>’ denotes unsigned right shift operator and always fill 0 irrespective of the sign of the number.
         */
        short result = 0;
        while (n != 0) {
            result ^= (n & 1);
            n >>>= 1;
        }
        return result;
    }

}
