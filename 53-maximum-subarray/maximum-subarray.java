class Solution {
    public int maxSubArray(int[] nums) {
        int max=Integer.MIN_VALUE;
        int current=0;

        for(int x:nums)
        {
            current+=x;
            if(current > max)
            {
                max=current;
            }
            if(current<0)
            {
                current=0;
            }
        }

        return max;
    }
}