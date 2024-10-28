class Solution {
    public int longestSquareStreak(int[] nums) {
          //Arrays.sort(nums);
        Set<Long> set=new HashSet<>();
          int maxcnt=-1;

          int n=nums.length;
          for(int num:nums)
          {
            set.add((long)num);
          }
          for(int num:nums)
          {
            long current=num;
            int cnt=1;
            while(set.contains(current*current))
            {
                current=current*current;
                cnt++;
            }
            if(cnt>=2)
              maxcnt=Math.max(cnt,maxcnt);
            
          }
        return maxcnt;
    }
}