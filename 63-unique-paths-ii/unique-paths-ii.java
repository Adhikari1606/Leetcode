class Solution {
    public int moves(int[][] obstacle, int[] arr1, int[] arr2, int i, int j, int[][] dp) {
        int row = obstacle.length;
        int col = obstacle[0].length;

        if (i == row - 1 && j == col - 1) {
            return 1;
        }

       
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int ctr = 0;

       
        for (int k = 0; k < 2; k++) {
            int n_row = i + arr1[k];
            int n_col = j + arr2[k];

           
            if (n_row < row && n_col < col && obstacle[n_row][n_col] == 0) {
                ctr += moves(obstacle, arr1, arr2, n_row, n_col, dp);
            }
        }

       
        dp[i][j] = ctr;
        return dp[i][j];
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
      
        if (obstacleGrid[0][0] == 1 || obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1) {
            return 0;
        }

        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] dp = new int[row][col];

        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dp[i][j] = -1;
            }
        }

        int[] arr1 = {0, 1}; // Down
        int[] arr2 = {1, 0}; // Right

        return moves(obstacleGrid, arr1, arr2, 0, 0, dp);
    }
}
