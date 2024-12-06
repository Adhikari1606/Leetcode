class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer>set=new HashSet<>();
        for(int x: banned)
        {
            set.add(x);
        }
        int ctr=0;
        int currSum=0;
        for(int i=1;i<=n;i++)
        {
            if(!set.contains(i) && currSum<=maxSum)
            {
                currSum+=i;
                if(currSum<=maxSum)
                {
                    ctr++;
                }
                else
                {
                    currSum-=i;
                }
            }
        }
        return ctr;
    }
}