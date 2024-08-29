import java.util.*;

class Solution {
    public void DFS(Map<Integer, List<Integer>> rows, Map<Integer, List<Integer>> cols, Set<String> visited, int i, int j) {
        String key = i + "," + j;
        if (visited.contains(key)) {
            return;
        }
        visited.add(key);
        if (rows.containsKey(i)) {
            for (int col : rows.get(i)) {
                DFS(rows, cols, visited, i, col);
            }
        }
        if (cols.containsKey(j)) {
            for (int row : cols.get(j)) {
                DFS(rows, cols, visited, row, j);
            }
        }
    }

    public int removeStones(int[][] stones) {
        Map<Integer, List<Integer>> rows = new HashMap<>();
        Map<Integer, List<Integer>> cols = new HashMap<>();
        Set<String> visited = new HashSet<>();
        int n = stones.length;
        for (int[] stone : stones) {
            int i = stone[0];
            int j = stone[1];

            rows.computeIfAbsent(i, x -> new ArrayList<>()).add(j);
            cols.computeIfAbsent(j, x -> new ArrayList<>()).add(i);
        }

        int connectedComponents = 0;
        for (int[] stone : stones) {
            int i = stone[0];
            int j = stone[1];
            String key = i + "," + j;
            if (!visited.contains(key)) {
                DFS(rows, cols, visited, i, j);
                connectedComponents++;
            }
        }

        return n - connectedComponents;
    }
}
