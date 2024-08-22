class Solution {
    public void sub(int ind,List<Integer>l,int[]arr,int s,List<List<Integer>>ans)
    {
        if(ind==s)
        {
            ans.add(new ArrayList<>(l));
            return;
        }
        sub(ind+1,l,arr,s,ans);
        l.add(arr[ind]);
        sub(ind+1,l,arr,s,ans);
        l.remove(l.size()-1);
    }
    public List<List<Integer>> subsets(int[] nums) {
         List<List<Integer>>ans=new ArrayList<>();
         List<Integer>l=new ArrayList<>();
         sub(0,l,nums,nums.length,ans);
         return ans;
    }
}