class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

       
        for (int gift : gifts) {
            maxHeap.add(gift);
        }

        long ans = 0;
        while (k-- > 0) {
            int largestGift = maxHeap.remove();
            int reducedGift = (int) Math.sqrt(largestGift); 
            maxHeap.add(reducedGift);
        }
        int size=maxHeap.size();
        while(size-->0)
        {
            ans+=maxHeap.remove();
        }
        return ans;
    }
}
