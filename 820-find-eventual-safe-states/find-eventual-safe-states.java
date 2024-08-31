import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
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
    }
}
