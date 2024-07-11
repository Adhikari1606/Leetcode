class Solution {
    private void dfs(int[][] vis, int sr, int sc, int color,int[][]image)
    {
        int tColor=image[sr][sc];
        image[sr][sc]=color;
        int R=image.length;
        int C=image[0].length;
        vis[sr][sc]=1;
        int []row={-1,0,1,0};
        int []col={0,1,0,-1};
        for(int i=0;i<4;i++)
        {
            int nrow=sr+row[i];
            int ncol=sc+col[i];
             if (nrow >= 0 && nrow < R && ncol >= 0 && ncol < C && vis[nrow][ncol] != 1 && image[nrow][ncol] == tColor) 
            {
                dfs(vis,nrow,ncol,color,image);
            }
        }
        
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int r=image.length;
        int c=image[0].length;
        int [][]vis=new int[r][c];
        dfs(vis,sr,sc,color,image);
        return image;
    }
}