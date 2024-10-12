/*import java.util.*;

class Pair {
    Set<Integer> set;

    Pair() {
        set = new HashSet<>();
    }

    Pair(int x, int y) {
        set = new HashSet<>();
        set.add(x);
        set.add(y);
    }

    public boolean contains(int x, int y) {
        return set.contains(x) || set.contains(y);  
    }

    public void add(int x, int y) {
        set.add(x);
        set.add(y);  
    }
}

class Solution {
    public int minGroups(int[][] intervals) {
        List<Pair> list = new ArrayList<>();
        int ctr = 0; 
        
        for (int[] x : intervals) {
            int a = x[0]; 
            int b = x[1]; 
            boolean added = false;  

           
            for (Pair p : list) {
                if (!p.contains(a, b)) {  
                    p.add(a, b);
                    added = true;
                    break;
                }
            }

           
            if (!added) {
                Pair newPair = new Pair(a, b);
                list.add(newPair);
                ctr++;  
            }
        }

        return ctr; 
    }
}
*/
class Solution {
    public int minGroups(int[][] intervals) {
        int n = intervals.length;
        int[] start_times = new int[n];
        int[] end_times = new int[n];

        // Extract start and end times
        for (int i = 0; i < n; i++) {
            start_times[i] = intervals[i][0];
            end_times[i] = intervals[i][1];
        }

        // Sort start and end times
        Arrays.sort(start_times);
        Arrays.sort(end_times);

        int end_ptr = 0, group_count = 0;

        // Traverse through the start times
        for (int start : start_times) {
            if (start > end_times[end_ptr]) {
                end_ptr++;
            } else {
                group_count++;
            }
        }

        return group_count;
    }
}