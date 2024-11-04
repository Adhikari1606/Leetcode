class Solution {
    public String compressedString(String word) {
        StringBuilder str = new StringBuilder();
        int len = word.length();
        int i = 0;

        while (i < len) {
            char currentChar = word.charAt(i);
            int ctr = 1;
            i++;

            while (i < len && word.charAt(i) == currentChar) {
                ctr++;
                i++;
            }
            while(ctr>9)
            {
                str.append(9).append(currentChar);
                ctr-=9;
            }
            if(ctr>0)
            str.append(ctr).append(currentChar);
        }

        return str.toString();
    }
}
