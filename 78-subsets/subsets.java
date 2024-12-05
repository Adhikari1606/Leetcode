class Solution {
    public void find(int[] nums,int i,int n,List<List<Integer>>list,List<Integer> sub)
    {
        if(i==n)
        {
            list.add(new ArrayList<>(sub));
            return ;
        }
        sub.add(nums[i]);
        find(nums,i+1,n,list,sub);

        sub.remove(sub.size()-1);
        find(nums,i+1,n,list,sub);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>list=new ArrayList<>();
        List<Integer>sub=new ArrayList<>();
        find(nums,0,nums.length,list,sub);
        return list;
    }
}