class Solution {
    /*public void helper(String s, Set<String>words ,int n ,int i,StringBuilder str)
    {
        // base condition 
        if(str.length()==3 || i==n)
        {
            if(str.length()==3 && isPalindrome(str.toString()))
            {
                words.add(str.toString());
            }
            return;
        }
        //pick the current element 
        str.append(s.charAt(i));
        helper(s,words,n,i+1,str);

        //backtrack
        str.deleteCharAt(str.length()-1);
        helper(s,words,n,i+1,str);

    }

    public boolean isPalindrome(String s)
    {
        int n=s.length();
        for(int i=0;i<n/2;i++)
        {
            if(s.charAt(i)!=s.charAt(n-1-i))
            {
                return false;
            }
        }
        return true;
    }

    public int countPalindromicSubsequence(String s) {
        Set<String>words=new HashSet<>();
        StringBuilder str=new StringBuilder();
        helper(s,words,s.length(),0,str);
        return words.size();

    }*/
    public int countPalindromicSubsequence(String s) {
    Set<String> words = new HashSet<>();
    int n = s.length();

    
    for (char ch = 'a'; ch <= 'z'; ch++) {
        int l = 0;
        int r = n - 1;

        while (l < n && s.charAt(l) != ch) {
            l++;
        }

        while (r >= 0 && s.charAt(r) != ch) {
            r--;
        }

        
        if (l < r) {
            for (int i = l + 1; i < r; i++) {
                words.add("" + ch + s.charAt(i) + ch);
            }
        }
    }

    return words.size();
}

}