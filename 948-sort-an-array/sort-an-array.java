class Solution {
    /*public int smallest(int[] nums,int i)
    {
        int min=nums[i];
        int index=i;
        for(int j=i;j<nums.length;j++)
        {
            if(nums[j]<min)
            {
                index=j;
                min=nums[j];
            }
        }
        return index;
    }*/
    public int[] sortArray(int[] nums) {
        /*for(int i=0;i<nums.length;i++)
        {
            int index=smallest(nums,i);
            if(index!=i)
            {
                int temp=nums[i];
                nums[i]=nums[index];
                nums[index]=temp;
            }
        }*/
        mergeSort(nums,0,nums.length-1);
        return nums;
    }
    public void mergeSort(int[] nums,int low,int high)
    {
        if(low>=high)
        {
            return ;
        }
        int mid=low+(high-low)/2;
        mergeSort(nums,low,mid);
        mergeSort(nums,mid+1,high);
        merge(nums,low,mid,high);
    }
        public void merge(int[] nums, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;
        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];

        System.arraycopy(nums, low, arr1, 0, n1);
        System.arraycopy(nums, mid + 1, arr2, 0, n2);

        int a = 0, b = 0, i = low;

        while (a < n1 && b < n2) {
            if (arr1[a] <= arr2[b]) {
                nums[i++] = arr1[a++];
            } else {
                nums[i++] = arr2[b++];
            }
        }

        while (a < n1) {
            nums[i++] = arr1[a++];
        }
        while (b < n2) {
            nums[i++] = arr2[b++];
        }
    }
}