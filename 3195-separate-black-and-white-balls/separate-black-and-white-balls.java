class Solution {
    public void swap(char[]arr ,int i,int j)
    {
        char temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public long minimumSteps(String s) {
        char str[]=s.toCharArray();
        int n=str.length;
    
        long ctr=0;
        int l=0;
        int r=0;
        while(r<n)
        {
            if(str[r]=='0')
            {
                ctr+=r-l;
                swap(str,l,r);
                l++;
            }
            r++;
        }
        return ctr;
    }
}