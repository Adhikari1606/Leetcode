class Solution {
   public String countOfAtoms(String formula) {
        int len = formula.length();
        Stack<Map<String, Integer>> stack = new Stack<>();
        stack.push(new TreeMap<>());
        int i = 0;

        while (i < len) {
            char c = formula.charAt(i);

            if (c == '(') {
                stack.push(new TreeMap<>());
                i++;
            } else if (c == ')') {
                i++;
                int start = i, multiplicity = 1;
                while (i < len && Character.isDigit(formula.charAt(i))) i++;
                if (i > start) multiplicity = Integer.parseInt(formula.substring(start, i));
                
                Map<String, Integer> top = stack.pop();
                Map<String, Integer> peek = stack.peek();

                for (String key : top.keySet()) {
                    peek.put(key, peek.getOrDefault(key, 0) + top.get(key) * multiplicity);
                }
            } else {
                int start = i++;
                while (i < len && Character.isLowerCase(formula.charAt(i))) i++;
                String name = formula.substring(start, i);
                start = i;
                while (i < len && Character.isDigit(formula.charAt(i))) i++;
                int multiplicity = i > start ? Integer.parseInt(formula.substring(start, i)) : 1;
                
                Map<String, Integer> peek = stack.peek();
                peek.put(name, peek.getOrDefault(name, 0) + multiplicity);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String name : stack.peek().keySet()) {
            sb.append(name);
            int count = stack.peek().get(name);
            if (count > 1) sb.append(count);
        }
        return sb.toString();
    }
}