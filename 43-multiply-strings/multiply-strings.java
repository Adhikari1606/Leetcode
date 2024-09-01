import java.math.BigInteger;

class Solution {
    public BigInteger convertint(String x) {
        BigInteger ans = BigInteger.ZERO;
        int len = x.length();
        int i = 0;
        while (len-- > 0) {
            char a = x.charAt(i++);
            BigInteger b = BigInteger.valueOf(a - '0');
            ans = ans.multiply(BigInteger.TEN).add(b);
        }
        return ans;
    }

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        BigInteger a = convertint(num1);
        BigInteger b = convertint(num2);
        BigInteger result = a.multiply(b);

        return result.toString();
    }
}
