class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stk = new Stack<>();
        int ctr = 0;
        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            if (x == ')') {
                if (!stk.isEmpty() && stk.peek() == '(') { 
                    stk.pop();
                } else {
                    ctr++;
                }
            } else {
                stk.add('(');
            }
        }
        ctr += stk.size();
        return ctr;
    }
}
