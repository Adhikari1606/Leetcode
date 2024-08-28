class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=0;
        int r=0;
        int n=s.length();
        Set<Character>set=new HashSet<>();
        int maxi=0;
        while(r<n && l<=r)
        {
            char ch=s.charAt(r);
            if(!set.contains(ch))
            {
                set.add(ch);
                maxi=Math.max(maxi,set.size());
                r++;
            }
            else
            {
                char ch1=s.charAt(l);
                set.remove(ch1);
                l++;
            }
            maxi=Math.max(maxi,r-l);
        }
        return maxi;
    }
}