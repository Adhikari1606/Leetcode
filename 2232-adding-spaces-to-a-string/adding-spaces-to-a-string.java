class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder str = new StringBuilder(); 
        int l = 0;
        for (int x : spaces) {
            str.append(s.substring(l, x)); 
            str.append(" "); 
            l = x; 
        }
        
        str.append(s.substring(l));
        return str.toString();
    }
}
