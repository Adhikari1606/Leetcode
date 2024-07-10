class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer>map=new HashMap<>();
        int l=0, r=0;
        int ans=0;

         while (r < s.length()) {
            char a = s.charAt(r);
            if (map.containsKey(a)) {
                l = Math.max(map.get(a) + 1, l);
            }
            map.put(a, r);
            ans = Math.max(ans, r - l + 1);
            r++;
        }
        return ans;
    }
}