class Solution {
    public int getLucky(String s, int k) {
        int l=s.length();
        int ans=0;
        for(int i=0;i<l;i++)
        {
            int num=s.charAt(i)-'a'+1;
            ans=ans+(num / 10) + (num % 10); ;
        }
        while (k-- > 1) {
            int temp = 0;
            while (ans > 0) {
                temp += ans % 10;
                ans /= 10;
            }
            ans = temp;
        }
        return ans;
    }
}