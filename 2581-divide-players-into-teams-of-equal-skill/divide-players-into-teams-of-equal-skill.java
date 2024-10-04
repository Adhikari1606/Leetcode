class Solution {
    public long dividePlayers(int[] skill) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int x : skill) {
            map.put(x, map.getOrDefault(x, 0) + 1);
            sum += x;
        }
        int n = skill.length;
        if(n==2)
        return skill[0]*skill[1];

        int target = sum / (n / 2);
        long ans = 0;
        for (int x : skill) {
            if (map.get(x) == 0) {
                continue;
            }
            int complement = target - x;
            if (map.getOrDefault(complement, 0) > 0) {
                ans += (long) x * complement;
                map.put(x, map.get(x) - 1);
                map.put(complement, map.get(complement) - 1);
            } else {
                return -1;
            }
        }

        return ans;
    }
}
