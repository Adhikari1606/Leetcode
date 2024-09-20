class Solution {
    public boolean isPalindrome(String s)
    {
        int size = s.length();
        for (int i = 0; i < size / 2; i++)
        {
            char a = s.charAt(i);
            char b = s.charAt(size - 1 - i);
            if (a != b)
                return false;
        }
        return true;
    }

    public int findLongestPalindromePrefix(String s)
    {
        int size = s.length();
        for (int i = size; i > 0; i--)
        {
            if (isPalindrome(s.substring(0, i)))
                return i;
        }
        return 0;
    }

    public String shortestPalindrome(String s) {
        int n = s.length();
        int palindromeEnd = findLongestPalindromePrefix(s);
        StringBuilder toMirror = new StringBuilder(s.substring(palindromeEnd));
        return toMirror.reverse().toString() + s;
    }
}
