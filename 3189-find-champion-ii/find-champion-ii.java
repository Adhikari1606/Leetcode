import java.util.*;

class Solution {
    // Method to create the adjacency list
    public List<List<Integer>> Adj(int n, int[][] edges) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int y = edge[0];
            int z = edge[1];
            list.get(y).add(z);
        }
        return list;
    }

    // Method to find the champion node
    public int findChampion(int n, int[][] edges) {
        // Create the adjacency list
        List<List<Integer>> list = Adj(n, edges);
        boolean[] reachable = new boolean[n];
        Arrays.fill(reachable, true);

        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);

            // BFS to check reachability
            while (!queue.isEmpty()) {
                int node = queue.poll();
                if (visited[node]) continue; // Skip already visited nodes
                visited[node] = true;

                for (int neighbor : list.get(node)) {
                    if (!visited[neighbor]) {
                        queue.offer(neighbor);
                    }
                }
            }

            // Check if all nodes are reachable
            for (int j = 0; j < n; j++) {
                if (!visited[j]) {
                    reachable[i] = false;
                    break;
                }
            }
        }

        // Find the champion node
        for (int i = 0; i < n; i++) {
            if (reachable[i]) return i;
        }

        return -1; 
    }
}
