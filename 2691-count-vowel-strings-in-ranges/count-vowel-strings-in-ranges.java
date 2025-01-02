//prefix sum 


class Solution {
    public boolean checkVowel(String s)
    {
        int n=s.length()-1;
        if((s.charAt(0)=='a'||s.charAt(0)=='e'||s.charAt(0)=='i'||s.charAt(0)=='o'||s.charAt(0)=='u')&& (s.charAt(n)=='a'||s.charAt(n)=='e'||s.charAt(n)=='i'||s.charAt(n)=='o'||s.charAt(n)=='u'))
        {
            return true;
        }
        return false;
    }
    public int[] vowelStrings(String[] words, int[][] queries) {
        int ans[] =new int[queries.length];
        int prefix[]=new int[words.length];
        if(checkVowel(words[0]))
        {
            prefix[0]=1;
        }
        for(int j=1;j<words.length;j++)
        {
            int ctr=0;
            if(checkVowel(words[j]))
            {
                ctr=1;
            }
            prefix[j]=prefix[j-1]+ctr;
        }
        int j=0;
        for(int x[]:queries)
        {
            int start = x[0];
            int end = x[1];
            if(start!=0)
            {
                ans[j++]=prefix[end]-prefix[start-1];
            }
            else
            {
                ans[j++]=prefix[end];
            }
        }
        return ans;
    }
}