class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>>list=new ArrayList<>();
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            if(nums[i]>0) break;
            if(i!=0 && nums[i-1]==nums[i])
            continue;
            int t=-nums[i];
            int l=i+1;
            int r=n-1;
            while(l<r)
            {
                if(nums[l]+nums[r]>t)
                {
                    r--;
                }
                else if(nums[l]+nums[r]<t)
                {
                    l++;
                }
                else
                {
                    List<Integer>list1=new ArrayList<>();
                    list1.add(nums[i]);
                    list1.add(nums[l]);
                    list1.add(nums[r]);
                    list.add(list1);
                    while(l<r && nums[l]==nums[l+1])l++;
                   while(l<r && nums[r]==nums[r-1])r--;
                    l++;
                    r--;
                }
            }
        }
        return list;
    }
}