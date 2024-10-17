/*class Solution {
    public int maximumSwap(int num) {
        String str = Integer.toString(num);
        int n = str.length();
        StringBuilder str1 = new StringBuilder(str);
        
        int k = -1;  // Initialize k to an invalid index
        Boolean flag = true;

        // Traverse to find the first decreasing pair
        for (int i = 0; i < n - 1; i++) {
            int a = str.charAt(i) - '0';
            int b = str.charAt(i + 1) - '0';
            if (a < b) {
                flag = false;
                k = i;  // Store the index of the first decrease
                break;  // Stop at the first decreasing pair
            }
        }

        // If the number is already in decreasing order, return it as is
        if (flag) {
            return num;
        }

        // Find the maximum digit and its rightmost occurrence after k
        int max = -1;
        int index = -1;
        for (int i = k + 1; i < n; i++) {
            int digit = str.charAt(i) - '0';
            if (digit >= max) {
                max = digit;
                index = i;
            }
        }

        // Swap the first decreasing digit with the maximum found after it
        char temp = str1.charAt(k);
        str1.setCharAt(k, str1.charAt(index));
        str1.setCharAt(index, temp);

        // Return the modified number as an integer
        return Integer.parseInt(str1.toString());
    }
}*/


class Solution {
    public int maximumSwap(int num) {
        String str = Integer.toString(num);
        int n = str.length();
        char[] digits = str.toCharArray();

        // Create an array to store the index of the maximum digit from the current index to the end
        int[] maxIndex = new int[n];
        maxIndex[n - 1] = n - 1;

        // Traverse from right to left to fill maxIndex array
        for (int i = n - 2; i >= 0; i--) {
            if (digits[i] > digits[maxIndex[i + 1]]) {
                maxIndex[i] = i;
            } else {
                maxIndex[i] = maxIndex[i + 1];
            }
        }

        // Traverse from left to right to find the first place where we can swap to get a larger number
        for (int i = 0; i < n; i++) {
            if (digits[i] < digits[maxIndex[i]]) {
                // Swap the digits
                char temp = digits[i];
                digits[i] = digits[maxIndex[i]];
                digits[maxIndex[i]] = temp;
                break;
            }
        }

        // Convert the array back to an integer and return
        return Integer.parseInt(new String(digits));
    }
}

