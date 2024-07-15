class Pair
{
    int row;
    int col;
    int dist;
    Pair(int row,int col,int dist)
    {
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}
class Solution {

    public int[][] updateMatrix(int[][] mat) {
        Queue<Pair>que=new LinkedList<>();
        int m=mat.length;
        int n=mat[0].length;
        int [][]vis=new int[m][n];
        int [][]ans=new int[m][n];

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(mat[i][j]==0)
                {
                    que.add(new Pair(i,j,0));
                    vis[i][j]=1;
                    ans[i][j]=0;
                }
            }
        }
        while(!que.isEmpty())
        {
            Pair temp=que.peek();
            int r=temp.row;
            int c=temp.col;
            int d=temp.dist;
            que.remove();
            int[] delrow={-1,0,1,0};
            int[]  delcol={0,1,0,-1};
            for(int i=0;i<4;i++)
            {
                int nrow=r+delrow[i];
                int ncol=c+delcol[i];

                if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && vis[nrow][ncol]==0)
                {
                    vis[nrow][ncol]=1;
                    ans[nrow][ncol]=d+1;
                    que.add(new Pair(nrow,ncol,d+1));
                }
            }
        }
        return ans;
    }
}