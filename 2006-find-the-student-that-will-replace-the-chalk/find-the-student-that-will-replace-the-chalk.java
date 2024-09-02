class Solution {
    public int chalkReplacer(int[] chalk, int k) {
       
        long totalSum = 0;
        for (int c : chalk) {
            totalSum += c;
        }
        k %= totalSum;
        
        for (int i = 0; i < chalk.length; i++) {
            if (chalk[i] > k) {
                return i;
            }
            k -= chalk[i];
        }
        return -1;
    }
}