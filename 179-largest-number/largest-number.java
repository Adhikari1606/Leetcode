class Solution {
    public String largestNumber(int[] nums) {
        String ans[]=new String[nums.length];
        int i=0;
        int flag=0;
        for(int x: nums)
        {
            if(flag==0 && x!=0)
            {
                flag=1;
            }
            ans[i++]=String.valueOf(x);
        }
        if(flag==0)
        return "0";
        Arrays.sort(ans,(a, b) -> (b + a).compareTo(a + b));
        StringBuilder anss=new StringBuilder();
        for(String s:ans)
        {
            anss.append(s);
        }
        return anss.toString();
    }
}