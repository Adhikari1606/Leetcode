import java.util.*;

class Solution {
    public int minimumObstacles(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        // Direction vectors for moving up, down, left, and right
        int[] rows = {0, -1, 0, 1};
        int[] cols = {-1, 0, 1, 0};

        // Priority Queue to store cells with the number of obstacles encountered
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));

        // Distance array to store the minimum obstacles to reach each cell
        int[][] distance = new int[row][col];
        for (int[] dist : distance) {
            Arrays.fill(dist, Integer.MAX_VALUE);
        }

        // Start BFS from the top-left corner
        pq.add(new int[]{0, 0, 0}); // {i, j, obstacles}
        distance[0][0] = 0;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int i = current[0];
            int j = current[1];
            int obstacles = current[2];

            // If we've reached the bottom-right corner, return the result
            if (i == row - 1 && j == col - 1) {
                return obstacles;
            }

            // Process all four possible directions
            for (int k = 0; k < 4; k++) {
                int newRow = i + rows[k];
                int newCol = j + cols[k];

                // Check if the new cell is within bounds
                if (newRow >= 0 && newCol >= 0 && newRow < row && newCol < col) {
                    // Calculate the new obstacle count for this path
                    int newObstacles = obstacles + grid[newRow][newCol];

                    // If this path has fewer obstacles, update and add to the priority queue
                    if (newObstacles < distance[newRow][newCol]) {
                        distance[newRow][newCol] = newObstacles;
                        pq.add(new int[]{newRow, newCol, newObstacles});
                    }
                }
            }
        }

        // If we exhaust the queue without reaching the bottom-right corner, return -1 (unreachable)
        return -1;
    }
}
