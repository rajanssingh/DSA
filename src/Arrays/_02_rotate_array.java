package Arrays;

public class _02_rotate_array {
    public static void main(String[] args) {
        int nums[] = new int[]{-1,99,100,2};
        int k = 2;

//        rotateUsingExtraSpace(nums, k);

        rotate(nums, k);
    }

    public static void rotate(int [] nums, int k){
        //reverse the array
        int n = nums.length;
        k = k%n;
        for(int i=0,j=n-1; i<=j;i++,j--){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }


        // reverse 0 - k
        for(int i=0,j=k-1;i<=j;i++,j--){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        // reverse k to n-1
        for(int i=k,j=n-1;i<=j;i++,j--){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        for(int i:nums){
            System.out.print(i + " ");
        }
    }

    public static void rotateUsingExtraSpace(int[] nums, int k) {
        int n = nums.length;
        k = k%n; // To avoid index out of bound when k > n;
        int arr[] = new int[n];
        int j=0;
        for(int i=n-k;i<n;i++){
            arr[j] = nums[i];
            j++;
        }
        for(int i=0;i<n-k;i++){
            arr[j] = nums[i];
            j++;
        }
        for(int i=0;i<n;i++){
            nums[i] = arr[i];
        }
    }
}
