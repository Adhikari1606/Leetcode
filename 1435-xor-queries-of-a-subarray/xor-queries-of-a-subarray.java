class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int answer[]=new int[queries.length];
        int j=0;
        for(int[] x :queries)
        {
            int start=x[0];
            int end=x[1];
            int val=0;
            for(int i=start;i<=end;i++)
            {
                val=val^arr[i];
            }
            answer[j++]=val;
        }
        return answer;
    }
}