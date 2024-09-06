class Solution {
    public boolean dfs(int node,int col,int []color,int[][]graph)
    {
        color[node]=col;
        for(int x:graph[node])
        {
            if(color[x]==-1)
            {
                if(dfs(x,1-col,color,graph)==false)
                return false;
            }
            else if(color[x]==col)
            return false;
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int[] color=new int[graph.length];
        for(int i=0;i<color.length;i++)
        {
            color[i]=-1;
        }
        for(int i=0;i<color.length;i++)
        {
            if(color[i]==-1)
            {
                if(dfs(i,0,color,graph)==false)
                return false;
            }
        }
        return true;
    }
}