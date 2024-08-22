class Solution {
    public int findComplement(int num) {
        int numBits = Integer.toBinaryString(num).length();
        return num^((1 << numBits) - 1);
    }
}