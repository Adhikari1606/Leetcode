class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        String[] arr1 = s1.split(" ");
        String[] arr2 = s2.split(" ");
        Map<String, Integer> map = new HashMap<>();
        
        for (String x : arr1) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        
        for (String x : arr2) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                list.add(entry.getKey());
            }
        }
        
        return list.toArray(new String[0]);
    }
}
