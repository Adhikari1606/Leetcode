class Solution {
    public boolean helper(String word , String pref)
    {
        if(word.length()==pref.length() && word.equals(pref))
        {
            return true;
        }
        if(word.length()>pref.length() && pref.equals(word.substring(0,pref.length()))){
            return true;
        }
        return false;
    }
    public int prefixCount(String[] words, String pref) {
        int ctr=0;
        for(String x: words)
        {
            if(helper(x,pref))
            {
                ctr++;
            }
        }
        return ctr;
    }
}