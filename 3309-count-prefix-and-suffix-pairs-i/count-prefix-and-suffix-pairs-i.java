class Solution {
    public boolean isPrefixAndSuffix(String str1,String str2)
    {
        if(str2.length()<str1.length())
        return false;

        if(str1.charAt(0) == str2.charAt(0) 
    && str1.equals(str2.substring(0, str1.length())) 
    && str1.equals(str2.substring(str2.length() - str1.length())))
        {
            return true;
        }
        return false;
    }
    public int countPrefixSuffixPairs(String[] words) {
        int count=0;
        for(int i=0;i<words.length;i++)
        {
            for(int j=i+1;j<words.length;j++)
            {
                if(isPrefixAndSuffix(words[i],words[j]))
                {
                    count++;
                }
            }
        }
        return count;
    }
}