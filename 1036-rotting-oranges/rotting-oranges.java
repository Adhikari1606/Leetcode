class Pair
{
    int r;
    int c;
    int t;
    Pair(int r,int c,int t)
    {
        this.r=r;
        this.c=c;
        this.t=t;
    }
}
class Solution {
    private void bfs(int sr,int sc,int time, Queue<Pair>que,int [][]vis,int [][]grid)
    {
        int row=grid.length;
        int col=grid[0].length;
        int []deltarow={-1,0,1,0};
        int []deltacol={0,1,0,-1};
        for(int i=0;i<4;i++)
        {
            int nrow=sr+deltarow[i];
            int ncol=sc+deltacol[i];
            if(nrow>=0 && nrow<row && ncol>=0 && ncol<col && vis[nrow][ncol]!=1 && grid[nrow][ncol]==1)
            {
                que.add(new Pair(nrow,ncol,time+1));
                vis[nrow][ncol]=1;
            }
        }
    }

    public int orangesRotting(int[][] grid) {
        Queue<Pair>que=new LinkedList<>();
        int row=grid.length;
        int col=grid[0].length;
        int [][]vis=new int[row][col];
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(grid[i][j]==2)
                {
                    que.add(new Pair(i,j,0));
                    vis[i][j]=1;
                }
            }
        }
        int sr=0;
        int sc=0;
        int time=0;;
        while(!que.isEmpty())
        {
            Pair current = que.poll();
            sr = current.r;
            sc = current.c;
            time = current.t;
            bfs(sr,sc,time,que,vis,grid);
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1 && vis[i][j] != 1) {
                    return -1;
                }
            }
        }
        return time;
    }
}