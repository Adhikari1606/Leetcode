class Solution {
    public void combination(int ind, int size, int target, int[] arr, List<List<Integer>> ans, List<Integer> temp) {
        if (target == 0) { 
            ans.add(new ArrayList<>(temp)); 
            return;
        }
        if (ind == size) {
            return;
        }
        if (arr[ind] <= target) { 
            temp.add(arr[ind]); 
            combination(ind, size, target - arr[ind], arr, ans, temp);
            temp.remove(temp.size() - 1);
        }
        combination(ind + 1, size, target, arr, ans, temp);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        combination(0,candidates.length,target,candidates,ans,temp);
        return ans;
    }
}