class Solution {
    public int[][] restoreMatrix(int[] rS, int[] cS) {
        int row=rS.length;
        int col=cS.length;
        int arr[][]=new int[row][col];
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(rS[i]<cS[j])
                {
                    arr[i][j]=rS[i];
                    cS[j]=cS[j]-rS[i];
                    rS[i]=0;
                }
                else if (rS[i]>cS[j])
                {
                    arr[i][j]=cS[j];
                    rS[i]=rS[i]-cS[j];
                    cS[j]=0;
                }
                else
                {
                    arr[i][j]=rS[i];
                    rS[i]=0;
                    cS[j]=0;
                }
            }
        }
        return arr;
    }
}