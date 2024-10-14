class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for(int x:nums)
        {
            maxHeap.add(x);
        }
        long score=0;
        while(k-->0)
        {
            int current_score=maxHeap.poll();
            score+=current_score;
            int new_score = (int) Math.ceil((double) current_score / 3);
            maxHeap.add(new_score);
        }
        return score;
    }
}