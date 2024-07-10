/*class Pair {
    int x;
    int y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    private void dfs(int row, int col, boolean[][] visited, char[][] grid) {
        visited[row][col] = true;
        Queue<Pair> que = new LinkedList<>();
        que.add(new Pair(row, col));
        int p = grid.length;
        int q = grid[0].length;

        while (!que.isEmpty()) {
            Pair current = que.poll();
            int x = current.x;
            int y = current.y;

            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (i == 0 && j == 0) continue; // Skip the current cell
                    int r = x + i;
                    int c = y + j;
                    if (r >= 0 && r < p && c >= 0 && c < q && grid[r][c] == '1' && !visited[r][c]) {
                        visited[r][c] = true;
                        que.add(new Pair(r, c));
                    }
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int ctr = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    ctr++;
                    dfs(i, j, visited, grid);
                }
            }
        }
        return ctr;
    }
}*/
class Solution {
    int row=0;
    int col=0;
    public int numIslands(char[][] grid) {
        row=grid.length;
        col=grid[0].length;
        int count=0;

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]=='1'){
                    dfs(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid,int i,int j){
       // Out of bound check;
        if (i < 0 || i >= row || j < 0 || j >= col || grid[i][j] != '1') {
            return;
        }
        // Mark the cell as visited
        grid[i][j] = '2';
        // DFS in all four directions
        dfs(grid, i, j - 1); // left
        dfs(grid, i - 1, j); // up
        dfs(grid, i, j + 1); // right
        dfs(grid, i + 1, j); // down
    }
}
