class Solution {
    public int noOfSetbits(int n)
    {
        int ctr=0;
        if(n==0)
        return 0;
        while(n!=0)
        {
            int t=n;
            if((t&1)==1)
            {
                ctr++;
            }
            n=n>>1;
        }
        return ctr;
    }
    
    public int minBitFlips(int start, int goal) {
        int xor=start^goal;
        return noOfSetbits(xor);
    }
}