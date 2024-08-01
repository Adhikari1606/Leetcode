class Solution {
    public int countSeniors(String[] details) {
        int size=details.length;
        int ans=0;
        for(int i=0;i<size;i++)
        {
            String a=details[i].substring(11,13);
            int age=Integer.parseInt(a);
            if(age>60) ans++;
        }
        return ans;
    }
}