class Solution {
    public String reverseParentheses(String s) {
        Stack<String> stk = new Stack<>();
        int size = s.length();
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < size; i++) {
            char temp = s.charAt(i);
            if (temp != ')') {
                stk.push(Character.toString(temp));
            } else {
                StringBuilder tempStr = new StringBuilder();
                while (!stk.isEmpty()) {
                    String temp1 = stk.pop();
                    if (!temp1.equals("(")) {
                        tempStr.append(temp1);
                    } else {
                        break;
                    }
                }
                for (int j = 0; j < tempStr.length(); j++) {
                    stk.push(Character.toString(tempStr.charAt(j)));
                }
            }
        }
        while (!stk.isEmpty()) {
            ans.insert(0, stk.pop());
        }

        return ans.toString();
    }
}