class Solution {
    public boolean canFinish(int V, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int first = prerequisites[i][0];
            int second = prerequisites[i][1];
            adj.get(second).add(first);
        }
        int[] indegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }
        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                que.add(i);
            }
        }
        int ctr = 0;
        while (!que.isEmpty()) {
            int x = que.poll();
            ctr++; 
            for (int it : adj.get(x)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    que.add(it);
                }
            }
        }
        return ctr == V;
    }
}
