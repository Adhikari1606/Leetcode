class Solution {
    public int countZero(String s)
    {
        int ctr=0;
        for(int i=0;i<s.length();i++)
        {
            char x=s.charAt(i);
            if(x=='0')
            {
                ctr++;
            }
        }
        return ctr;
    }
    public int countOne(String s)
    {
        int ctr=0;
        for(int i=0;i<s.length();i++)
        {
            char x=s.charAt(i);
            if(x=='1')
            {
                ctr++;
            }
        }
        return ctr;
    }
    public int maxScore(String s) {
        int maxi=0;
        for(int i=1;i<s.length();i++)
        {
            String a=s.substring(0,i);
            String b=s.substring(i,s.length());
            int ans=countZero(a)+countOne(b);
            maxi=Math.max(ans,maxi);
            /*System.out.println("left "+a);
            System.out.println(b);*/
        }
        return maxi;
    }
}