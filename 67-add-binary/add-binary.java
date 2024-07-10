class Solution {
    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int rem = 0;
        int size1 = a.length();
        int size2 = b.length();
        int i = 0;
        while (i < size1 && i < size2) {
            int x = (a.charAt(size1 - i - 1) == '0') ? 0 : 1;
            int y = (b.charAt(size2 - i - 1) == '0') ? 0 : 1;
            int sum = rem + x + y;

            ans.append(sum % 2);
            rem = sum / 2;
            i++;
        }
        while (i < size1) {
            int x = (a.charAt(size1 - i - 1) == '0') ? 0 : 1;
            int sum = rem + x;

            ans.append(sum % 2);
            rem = sum / 2;
            i++;
        }
        while (i < size2) {
            int y = (b.charAt(size2 - i - 1) == '0') ? 0 : 1;
            int sum = rem + y;

            ans.append(sum % 2);
            rem = sum / 2;
            i++;
        }
        if (rem > 0) {
            ans.append(rem);
        }
        ans.reverse();
        return ans.toString();
    }
}
