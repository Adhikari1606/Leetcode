class Solution {
    int row = 0;
    int col = 0;

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        row = grid1.length;
        col = grid1[0].length;
        int count = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid2[i][j] == 1 && dfs(grid1, grid2, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    public boolean dfs(int[][] grid1, int[][] grid2, int i, int j) {
        if (i < 0 || i >= row || j < 0 || j >= col || grid2[i][j] != 1) {
            return true;
        }
        if (grid1[i][j] == 0 && grid2[i][j] == 1) {
            return false;
        }
        grid2[i][j] = 2;
        boolean up = dfs(grid1, grid2, i - 1, j);
        boolean down = dfs(grid1, grid2, i + 1, j);
        boolean left = dfs(grid1, grid2, i, j - 1);
        boolean right = dfs(grid1, grid2, i, j + 1);
        return up && down && left && right;
    }
}
