import java.util.HashMap;

class Solution {
    public int minSubarray(int[] nums, int p) {
        int target = 0;
        for (int x : nums) {
            target = (target + x) % p;
        }
        if (target == 0) {
            return 0; 
        }

        HashMap<Integer, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0, -1); 
        int prefixSum = 0;
        int minLen = nums.length;

        for (int i = 0; i < nums.length; i++) {
            prefixSum = (prefixSum + nums[i]) % p;
            int needed = (prefixSum - target + p) % p;

            if (prefixMap.containsKey(needed)) {
                minLen = Math.min(minLen, i - prefixMap.get(needed));
            }

            prefixMap.put(prefixSum, i);
        }

        return (minLen == nums.length) ? -1 : minLen;
    }
}
