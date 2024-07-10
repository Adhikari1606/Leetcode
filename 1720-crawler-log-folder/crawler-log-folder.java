class Solution {
    public int minOperations(String[] logs) {
        int ctr=0;
        for(int i=0;i<logs.length;i++)
        {
            if(logs[i].equals("../"))
            {
                if(ctr>0)
                ctr--;
            }
            else if(logs[i].equals("./"))
            {
                continue;
            }
            else
            {
                ctr++;
            }
        }
        return ctr;
    }
}