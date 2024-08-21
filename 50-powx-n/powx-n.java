class Solution {
    public double myPow(double a, int b) {
     if (b == 0) return 1.0;
        double res = 1;
        long absB = Math.abs((long)b);  // Use long to handle overflow

        while (absB > 0) {
            if ((absB & 1) == 1) {
                res *= a;
            }
            a *= a;
            absB >>= 1;
        }

        if (b < 0) {
            res = 1.0 / res;
        }

        return res;
    }
}