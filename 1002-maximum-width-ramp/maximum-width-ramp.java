/*class Solution {
    public int maxWidthRamp(int[] nums) {
        int i=0;
        int r=nums.length;
        int max=Integer.MIN_VALUE;
        int l=0;
        while(l<r)
        {
            if(nums[l]<=nums[r-1])
            {
                max=Math.max(max,r-l-1);
                break;
            }
            r--;
        }
        l=0;
        r=nums.length;
        while(l<r)
        {
            if(nums[l]<=nums[r-1])
            {
                max=Math.max(max,r-l-1);
                break;
            }
            l++;
        }
        return (max==Integer.MIN_VALUE)?0:max;
    }
}*/
class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty() || nums[stack.peek()] > nums[i]) {
                stack.push(i);
            }
        }
        
        int max = 0;
        
        for (int j = n - 1; j >= 0; j--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[j]) {
                max = Math.max(max, j - stack.pop());
            }
        }
        
        return max;
    }
}
