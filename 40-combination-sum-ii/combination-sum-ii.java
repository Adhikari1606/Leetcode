import java.util.*;

class Solution {
    public void combination(int ind, int size, int target, int[] arr, List<List<Integer>> ans, List<Integer> temp) {
        if (target == 0) {
            ans.add(new ArrayList<>(temp)); 
            return;
        }
        for (int i = ind; i < size; i++) {
            if (i > ind && arr[i] == arr[i - 1]) continue;
            if (arr[i] > target) break;
            temp.add(arr[i]);
            combination(i + 1, size, target - arr[i], arr, ans, temp);
            temp.remove(temp.size() - 1);
        }
    }
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates); 
        combination(0, candidates.length, target, candidates, ans, temp);
        return ans;
    }
}
