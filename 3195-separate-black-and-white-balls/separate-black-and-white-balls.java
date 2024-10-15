class Solution {
     public long minimumSteps(String s) {
        int n=s.length();
    
        long ctr=0;
        int l=0;
        int r=0;
        while(r<n)
        {
            if(s.charAt(r)=='0')
            {
                ctr+=r-l;
                l++;
            }
            r++;
        }
        return ctr;
    }
}