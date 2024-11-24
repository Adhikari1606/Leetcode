class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum = 0;
        int min = Integer.MAX_VALUE;
        int negativeCount = 0;
        
        for (int[] row : matrix) {
            for (int value : row) {
                sum += Math.abs(value);
                if (value < 0) {
                    negativeCount++;
                }
                min = Math.min(min, Math.abs(value));
            }
        }
        
       
        if (negativeCount % 2 == 0) {
            return sum;
        }
       
        return sum - 2 * min;
    }
}
