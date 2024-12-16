
class Pair {
    int val;
    int ind;

    Pair(int a, int b) {
        this.val = a;
        this.ind = b;
    }
}

class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
       
        PriorityQueue<Pair> queue = new PriorityQueue<>(
            (a, b) -> a.val != b.val ? a.val - b.val : a.ind - b.ind
        );
      
        for (int i = 0; i < nums.length; i++) {
            queue.add(new Pair(nums[i], i));
        }
        while (k-- > 0) {
            Pair temp = queue.poll(); 
            int val = temp.val;
            int ind = temp.ind;

           
            val = val * multiplier;
            queue.add(new Pair(val, ind));
        }

        
        while (!queue.isEmpty()) {
            Pair temp = queue.poll();
            int ind = temp.ind;
            int val = temp.val;

            nums[ind] = val;
        }

        return nums;
    }
}
