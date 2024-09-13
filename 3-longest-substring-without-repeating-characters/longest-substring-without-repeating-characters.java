class Solution {
    public int lengthOfLongestSubstring(String s) {
       int l=0;
       int r=0;
       int n=s.length();
       Set<Character>set=new HashSet<>();
       int len=0;
       while(l<=r && r<n)
       {
         char a=s.charAt(r);
         if(!set.contains(a))
         {
            set.add(a);
            len=Math.max(len,set.size());
            r++;
         }
         else
         {
            while(set.contains(a)&& l<r)
            {
                char b=s.charAt(l);
                set.remove(b);
                l++;
            }
         }
       }

       return len;
    }
}