import java.util.Stack;

class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Character> stk = new Stack<>();
        int len = s.length();
        String finalStr = "";
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                if (!stk.isEmpty()) {
                    finalStr += c;  
                }
                stk.push(c);
            } else {
                stk.pop();
                if (!stk.isEmpty()) {
                    finalStr += c;  
                }
            }
        }
        return finalStr;
    }
}
