class Solution {
 /* public int search(int[] nums, int target) {
        int k = findRotationPoint(nums);
        int index, index1;
            index = Arrays.binarySearch(nums, 0, k, target);
            index1 = Arrays.binarySearch(nums, k, nums.length, target);
            int ans=Math.max(index,index1);
            return (ans>=0)?ans:-1;
       
    }
    private int findRotationPoint(int[] nums) {
         int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }*/

    public int search(int[] nums, int target) {
    int l = 0;
    int r = nums.length - 1;

    while (l <= r) {
        int mid = l + (r - l) / 2;

        
        if (nums[mid] == target) {
            return mid;
        }

        
        if (nums[l] <= nums[mid]) { 
            if (nums[l] <= target && target < nums[mid]) {
                r = mid - 1; 
            } else {
                l = mid + 1; 
            }
        } else { 
            if (nums[mid] < target && target <= nums[r]) {
                l = mid + 1; 
            } else {
                r = mid - 1; 
            }
        }
    }

    return -1; 
}

}