import java.util.*;

class Solution {
    public int[][] validArrangement(int[][] pairs) {
        
        Map<Integer, List<Integer>> graph = new HashMap<>();
       
        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, Integer> outDegree = new HashMap<>();
        
        
        for (int[] pair : pairs) {
            int start = pair[0], end = pair[1];
            graph.putIfAbsent(start, new ArrayList<>());
            graph.get(start).add(end);
            outDegree.put(start, outDegree.getOrDefault(start, 0) + 1);
            inDegree.put(end, inDegree.getOrDefault(end, 0) + 1);
        }
        
     
        int startNode = pairs[0][0];
        for (int node : graph.keySet()) {
            int out = outDegree.getOrDefault(node, 0);
            int in = inDegree.getOrDefault(node, 0);
            if (out > in) {
                startNode = node;
                break;
            }
        }
        
        
        List<int[]> result = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(startNode);
        Deque<Integer> path = new ArrayDeque<>();
        
        while (!stack.isEmpty()) {
            int node = stack.peek();
            if (graph.containsKey(node) && !graph.get(node).isEmpty()) {
                stack.push(graph.get(node).remove(graph.get(node).size() - 1));
            } else {
                path.push(stack.pop());
            }
        }
        
        
        while (path.size() > 1) {
            int u = path.pop();
            int v = path.peek();
            result.add(new int[] { u, v });
        }
        
        return result.toArray(new int[0][0]);
    }
}
