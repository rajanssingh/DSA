package Arrays;

public class _05_First_LastPosition_Sorted_Array {
    public static void main(String[] args) {
        int [] nums = new int[]{};

        int [] ans = searchRange(nums, 0);
        System.out.println(ans[0] + " --> " + ans[1]);
    }

    public static int[] searchRange(int[] nums, int target) {
        int [] ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;


        int n = nums.length;
        int start = 0, end = n-1;

        while(start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                ans[0] = mid;
                end = mid - 1;
            }
            else if(nums[mid] > target) {
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }

        start = 0; end = n-1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                ans[1] = mid;
                start = mid + 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }
}
