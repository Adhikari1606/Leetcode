class Solution {
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        
        Map<Integer, String> ones = new HashMap<>();
        Map<Integer, String> teens = new HashMap<>();
        Map<Integer, String> tens = new HashMap<>();
        
        ones.put(1, "One");
        ones.put(2, "Two");
        ones.put(3, "Three");
        ones.put(4, "Four");
        ones.put(5, "Five");
        ones.put(6, "Six");
        ones.put(7, "Seven");
        ones.put(8, "Eight");
        ones.put(9, "Nine");
        
        teens.put(10, "Ten");
        teens.put(11, "Eleven");
        teens.put(12, "Twelve");
        teens.put(13, "Thirteen");
        teens.put(14, "Fourteen");
        teens.put(15, "Fifteen");
        teens.put(16, "Sixteen");
        teens.put(17, "Seventeen");
        teens.put(18, "Eighteen");
        teens.put(19, "Nineteen");
        
        tens.put(2, "Twenty");
        tens.put(3, "Thirty");
        tens.put(4, "Forty");
        tens.put(5, "Fifty");
        tens.put(6, "Sixty");
        tens.put(7, "Seventy");
        tens.put(8, "Eighty");
        tens.put(9, "Ninety");
        
        String result = convert(num, ones, teens, tens);
        return result.trim();
    }
    
    private String convert(int num, Map<Integer, String> ones, Map<Integer, String> teens, Map<Integer, String> tens) {
        if (num == 0) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        
        if (num >= 1_000_000_000) {
            sb.append(convert(num / 1_000_000_000, ones, teens, tens)).append("Billion ");
            num %= 1_000_000_000;
        }
        
        if (num >= 1_000_000) {
            sb.append(convert(num / 1_000_000, ones, teens, tens)).append("Million ");
            num %= 1_000_000;
        }
        
        if (num >= 1_000) {
            sb.append(convert(num / 1_000, ones, teens, tens)).append("Thousand ");
            num %= 1_000;
        }
        
        if (num >= 100) {
            sb.append(convert(num / 100, ones, teens, tens)).append("Hundred ");
            num %= 100;
        }
        
        if (num >= 20) {
            sb.append(tens.get(num / 10)).append(" ");
            num %= 10;
        } else if (num >= 10) {
            sb.append(teens.get(num)).append(" ");
            num = 0;
        }
        
        if (num > 0) {
            sb.append(ones.get(num)).append(" ");
        }
        
        return sb.toString();
    }
}
