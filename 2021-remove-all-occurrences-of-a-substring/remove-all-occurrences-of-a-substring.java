class Solution {
    public String helper(String s ,String part)
    {
        StringBuilder str=new StringBuilder(s);
        while (str.indexOf(part) != -1) {  
            int index = str.indexOf(part);
            str.delete(index, index + part.length()); 
        }
        return str.toString();
    }
    public String removeOccurrences(String s, String part) {
        return helper(s,part);
    }
}