class Solution {
    public int findTheWinner(int n, int k) {
        List<Integer>list=new ArrayList<>();
        for(int i=0;i<n;i++){
        list.add(i+1);
        }
        int l_index=0;
        //if(list.size()==1 && k==1) return 0;
        while(list.size()!=1)
        {
            int temp=(l_index+k-1)%list.size();
            list.remove(temp);
            l_index=temp;
        }
        return list.get(0);

    }
}