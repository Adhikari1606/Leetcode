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
    public void solve(char[][] board) {
        Queue<Pair>que=new LinkedList<>();
        int m=board.length;
        int n=board[0].length;
        int [][]vis=new int[m][n];
        int []delrow={-1,0,1,0};
        int []delcol={0,1,0,-1};
        for(int i=0;i<n;i++)
        {
            if(board[0][i]=='O')
            {
                que.add(new Pair(0,i));
                vis[0][i]=1;
            }
            if(board[m-1][i]=='O')
            {
                que.add(new Pair(m-1,i));
                vis[m-1][i]=1;
            }
        }
        for(int i=0;i<m;i++)
        {
            if(board[i][0]=='O' )
            {
                que.add(new Pair(i,0));
                vis[i][0]=1;
            }
            if(board[i][n-1]=='O')
            {
                que.add(new Pair(i,n-1));
                vis[i][n-1]=1;
            }
        }
        while(!que.isEmpty())
        {
            Pair temp=que.peek();
            int row=temp.r;
            int col=temp.c;
            que.remove();
            for(int i=0;i<4;i++)
            {
                int nrow=row+delrow[i];
                int ncol=col+delcol[i];

                if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && vis[nrow][ncol]!=1 && board[nrow][ncol]=='O')
                {
                    vis[nrow][ncol]=1;
                    que.add(new Pair(nrow,ncol));
                }
            }
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(board[i][j]=='O' && vis[i][j]==0)
                {
                    board[i][j]='X';
                }
            }
        }
    }
}