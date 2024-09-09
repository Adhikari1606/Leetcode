class Solution {
   public boolean dfs(int a, int[][] graph, int[] visited, int[] pathvisited) {
        visited[a] = 1;
        pathvisited[a] = 1;
        
        for (int it : graph[a]) {
            if (visited[it] == 0) {
                if (!dfs(it, graph, visited, pathvisited)) {
                    return false;
                }
            } else if (pathvisited[it] == 1) {
                return false;
            }
        }

        pathvisited[a] = 0;
        return true;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> safeNodes = new ArrayList<>();
        int[] visited = new int[graph.length];
        int[] pathvisited = new int[graph.length];
        
        for (int i = 0; i < graph.length; i++) {
            if ( dfs(i, graph, visited, pathvisited)) {
                safeNodes.add(i);
            }
        }
        
        return safeNodes;
    }

    /*public List<Integer> eventualSafeNodes(int[][] graph) {
        int len = graph.length;
        List<Integer> result = new ArrayList<>();
        int[] state = new int[len];
        
        for (int i = 0; i < len; i++) {
            if (dfs(i, graph, state)) result.add(i);
        }
        
        return result;
    }
    
    public boolean dfs(int node, int[][] graph, int[] state) {
        if (state[node] != 0) return state[node] == 2;
        state[node] = 1;
        for (int neighbor : graph[node]) {
            if (state[neighbor] == 2) continue;
            if (state[neighbor] == 1 || !dfs(neighbor, graph, state)) return false;
        }
        state[node] = 2;
        return true;
    }*/
}
