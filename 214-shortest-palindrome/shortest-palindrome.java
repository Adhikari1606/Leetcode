class Solution {
     public boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public int findLongestPalindromePrefix(String s) {
        int size = s.length();
        for (int i = size - 1; i >= 0; i--) {
            if (isPalindrome(s, 0, i)) {
                return i + 1;
            }
        }
        return 0;
    }

    public String shortestPalindrome(String s) {
        int palindromeEnd = findLongestPalindromePrefix(s);
        StringBuilder result = new StringBuilder();
        for (int i = s.length() - 1; i >= palindromeEnd; i--) {
            result.append(s.charAt(i));
        }
        result.append(s);
        return result.toString();
    }
}
