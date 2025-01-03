class Solution {
    public int waysToSplitArray(int[] nums) {
        long sum=0;
        for(int x: nums)
        {
            sum+=x;
        }
        int split=0;
        long currSum=0;
        for(int i=0;i<nums.length-1;i++)
        {
            currSum+=nums[i];
            long last=sum-currSum;
            if(currSum>=last)
            {
                split++;
            }
        }
        return split;
    }
}