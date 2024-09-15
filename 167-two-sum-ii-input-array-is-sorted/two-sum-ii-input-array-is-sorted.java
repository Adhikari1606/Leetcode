class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n=numbers.length;
        int l=0;
        int r=n-1;
        int arr[]=new int[2];
        while(l<r)
        {
            if(numbers[l]+numbers[r]>target)
            {
                r--;
            }
            else if(numbers[l]+numbers[r]<target)
            {
                l++;
            }
            else
            {
                arr[0]=l+1;
                arr[1]=r+1;
                break;
            }
        }
        return arr;

    }
}