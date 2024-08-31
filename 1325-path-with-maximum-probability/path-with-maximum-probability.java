import java.util.*;

class Pair {
    int node;
    float weight;

    Pair(int node, float weight) {
        this.node = node;
        this.weight = weight;
    }
}

class Solution {
    public void Bfs(int s, List<List<Pair>> adjList, float[] dist) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingDouble(p -> -p.weight));
        pq.add(new Pair(s, 1.0f));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int u = current.node;
            float currentDist = current.weight;

            for (Pair neighbor : adjList.get(u)) {
                int v = neighbor.node;
                float weight = neighbor.weight;

                if (currentDist * weight > dist[v]) {
                    dist[v] = currentDist * weight;
                    pq.add(new Pair(v, dist[v]));
                }
            }
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        float[] arr = new float[n];
        Arrays.fill(arr, 0.0f);
        arr[start_node] = 1.0f;

        List<List<Pair>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            float prob = (float) succProb[i];
            adjList.get(u).add(new Pair(v, prob));
            adjList.get(v).add(new Pair(u, prob));
        }

        Bfs(start_node, adjList, arr);

        return arr[end_node];
    }
}
