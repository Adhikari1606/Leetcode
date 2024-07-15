class Pair
{
    int r;
    int c;
    Pair(int r,int c)
    {
        this.r=r;
        this.c=c;
    }
}
class Solution {
    
      public int numEnclaves(int[][] grid) {
        Stack<Pair> stk = new Stack<>();
        int m = grid.length;
        int n = grid[0].length;
        int ctr = 0;
        int[][] vis = new int[m][n];
        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};

        for (int i = 0; i < n; i++) {
            if (grid[0][i] == 1) {
                stk.push(new Pair(0, i));
                vis[0][i] = 1;
            }

            if (grid[m - 1][i] == 1) {
                stk.push(new Pair(m - 1, i));
                vis[m - 1][i] = 1;
            }
        }
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1 && vis[i][0] == 0) {
                stk.push(new Pair(i, 0));
                vis[i][0] = 1;
            }
            if (grid[i][n - 1] == 1 && vis[i][n - 1] == 0) {
                stk.push(new Pair(i, n - 1));
                vis[i][n - 1] = 1;
            }
        }
        while (!stk.isEmpty()) {
            Pair temp = stk.pop();
            int row = temp.r;
            int col = temp.c;
            for (int i = 0; i < 4; i++) {  
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];

                if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                    vis[nrow][ncol] = 1;
                    stk.push(new Pair(nrow, ncol));
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && vis[i][j] != 1) {
                    ctr++;
                }
            }
        }
        return ctr;
    }
}