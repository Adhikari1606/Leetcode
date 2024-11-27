import java.util.*;

class Solution {

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int[] ans = new int[queries.length];
        List<List<Integer>> graph = new ArrayList<>();

      
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<n-1;i++)
        {
            graph.get(i).add(i+1);
        }

        for (int i = 0; i < queries.length; i++) {
            
            graph.get(queries[i][0]).add(queries[i][1]);

        
            ans[i] = bfs(0, n - 1, graph, n); 
        }

        return ans;
    }

    private int bfs(int start, int end, List<List<Integer>> graph, int n) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        int[] distance = new int[n];
        Arrays.fill(distance, -1);

        
        queue.offer(start);
        visited[start] = true;
        distance[start] = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                    distance[neighbor] = distance[node] + 1;

                    if (neighbor == end) {
                        return distance[neighbor];
                    }
                }
            }
        }

        return -1;
    }
}
