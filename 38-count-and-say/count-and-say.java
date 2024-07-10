class Solution {
    public String RLE(String str) {
        int ctr = 1;
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (i + 1 < str.length() && str.charAt(i) == str.charAt(i + 1)) {
                ctr++;
            } else {
                ans.append(ctr).append(str.charAt(i));
                ctr = 1;
            }
        }
        return ans.toString();
    }

    public String countAndSay(int n) {
        if (n == 1) return "1";
        String[] arr = new String[n + 1];
        arr[1] = "1";
        for (int i = 2; i <= n; i++) {
            String temp = arr[i - 1];
            arr[i] = RLE(temp);
        }
        return arr[n];
    }
}
