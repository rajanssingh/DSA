package Arrays;

import java.util.Arrays;

public class _07_Sort_Colors {
    public static void main(String[] args) {
//        sortColorsSinglePass(new int[]{1,2,2,2,2,0,0,0,1,1});
        sortColorsSinglePass(new int[]{2,0,2,1,1,0});
    }

    public static void sortColorsTwoPass(int[] nums) {
        // Counting sort O(2n)
        int countZero = 0;
        int countOne = 0;

        for (int i : nums) {
            if (i == 0) {
                countZero++;
            } else if (i == 1) {
                countOne++;
            } else {
                continue;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (countZero != 0) {
                nums[i] = 0;
                countZero--;
            } else if (countOne != 0) {
                nums[i] = 1;
                countOne--;
            } else {
                nums[i] = 2;
            }
        }

        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

    public static void sortColorsSinglePass(int[] nums) {
        // O(n)
        int first = 0, last = nums.length - 1;
        int oneEncountered = -1;
        while (first <= last) {
            if (nums[first] == 2) {
                int temp = nums[first];
                nums[first] = nums[last];
                nums[last] = temp;
                last--;
            } else if (nums[first] == 1) {
                if (nums[last] == 0) {
                    if (oneEncountered != -1) {
                        nums[oneEncountered] = 0;
                        if (oneEncountered < nums.length && nums[oneEncountered + 1] == 1) {
                            oneEncountered++;
                        } else {
                            oneEncountered = -1;
                        }
                        nums[last] = 1;
                    } else {
                        nums[first] = 0;
                        nums[last] = 1;
                        first++;
                    }
                } else if (oneEncountered == -1) {
                    oneEncountered = first;
                    first++;
                } else {
                    first++;
                }

            } else if (nums[first] == 0) {
                if (oneEncountered != -1) {
                    nums[first] = 1;
                    nums[oneEncountered] = 0;
                    if (oneEncountered < nums.length - 1 && nums[oneEncountered + 1] == 1) {
                        oneEncountered++;
                    } else {
                        oneEncountered = -1;
                    }
                }
                first++;

            }
        }
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }
}
