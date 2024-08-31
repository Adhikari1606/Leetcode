import java.util.*;

class Solution {
    void dfs(int x, boolean[] visited, List<List<Integer>> Adj) {
        visited[x] = true;
        for (int y : Adj.get(x)) {
            if (!visited[y]) {
                dfs(y, visited, Adj);
            }
        }
    }
    
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        List<List<Integer>> Adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Adj.add(new ArrayList<>());
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    Adj.get(i).add(j);
                  
                }
            }
        }
        
        int ctr = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                ctr++;
                dfs(i, visited, Adj);
            }
        }
        
        return ctr;
    }
}