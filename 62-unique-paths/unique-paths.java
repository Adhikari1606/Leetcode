class Solution {
    public int  moves(int[][] path, int row ,int col, int i, int j, int [][]dp)
    {
        int [] arr1={1,0};
        int [] arr2={0,1};
        if(i==row-1 && j==col-1)
        {
            return 1;
        }
        if(dp[i][j]!=0)
        {
            return dp[i][j];
        }
        int ctr=0;
        for(int k=0;k<2;k++)
        {
            int n_row=i+arr1[k];
            int n_col=j+arr2[k];

            if(n_row>=0 && n_col>=0 && n_row<row && n_col<col)
            {
                ctr+=moves(path,row,col,n_row,n_col,dp);
            }
        }
        dp[i][j]=ctr;
        return dp[i][j];
    }
    public int uniquePaths(int m, int n) {
        int [][] path=new int[m][n];
        int [][] dp=new int[m][n];
        return moves(path,m,n,0,0,dp);
    }

   


}