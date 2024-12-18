import java.util.Stack;

class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            // Find the next smaller or equal price
            while (!stack.isEmpty() && stack.peek() > prices[i]) {
                stack.pop();
            }
            // If stack is empty, no discount applies
            ans[i] = prices[i] - (stack.isEmpty() ? 0 : stack.peek());
            // Push the current price onto the stack
            stack.push(prices[i]);
        }
        return ans;
    }
}
