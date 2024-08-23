import java.util.ArrayList;
import java.util.List;

class Solution {
    public int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public String fractionAddition(String expression) {
        StringBuilder str = new StringBuilder(expression);
        if (str.charAt(0) != '-' && str.charAt(0) != '+')
            str.insert(0, '+');
        
        List<Integer> nume = new ArrayList<>();
        List<Integer> deno = new ArrayList<>();
        List<String> Sign = new ArrayList<>();
        
        int len = str.length();
        int j = 0;
        
        for (int i = 0; i < len;) {
            Sign.add(String.valueOf(str.charAt(i)));
            i++;
            StringBuilder numBuilder = new StringBuilder();
            while (i < len && str.charAt(i) != '/') {
                numBuilder.append(str.charAt(i));
                i++;
            }
            nume.add(Integer.parseInt(numBuilder.toString()));
            i++;
            StringBuilder denoBuilder = new StringBuilder();
            while (i < len && (str.charAt(i) != '+' && str.charAt(i) != '-')) {
                denoBuilder.append(str.charAt(i));
                i++;
            }
            deno.add(Integer.parseInt(denoBuilder.toString()));
            j++;
        }
        int mul = 1;
        for (int x : deno) {
            mul *= x;
        }
        for (int i = 0; i < j; i++) {
            if (Sign.get(i).equals("-")) {
                nume.set(i, -nume.get(i));
            }
            int a = mul / deno.get(i);
            nume.set(i, a * nume.get(i));
        }
        int ans = 0;
        for (int i = 0; i < j; i++) {
            ans += nume.get(i);
        }
        StringBuilder Fans = new StringBuilder();
        if (Math.abs(ans) % mul == 0) {
            int a = ans / mul;
            Fans.append(a).append("/1");
        } else {
            int hcf = gcd(Math.abs(ans), mul);
            Fans.append((ans / hcf)).append("/").append(mul / hcf);
        }
        return Fans.toString();
    }
}
