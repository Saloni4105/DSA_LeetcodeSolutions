class Solution {
    public int reversePairs(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        return mergeSort(nums, 0, nums.length-1);
    }

    private int mergeSort(int nums[], int start, int end)
    {
        if(start >= end) return 0;

        int mid = start + (end - start) / 2;
        int leftPart = mergeSort(nums, start, mid);
        int rightPart = mergeSort(nums, mid + 1, end);
        int count = leftPart + rightPart;

        // count reverse Pairs
        int j = mid + 1;
        for(int i = start; i <= mid; i++)
        {
            while(j <= end && (long)nums[i] > 2L * nums[j])
            {
                j++;
            }
            count += (j - (mid + 1));
        }

        // merge two sorted halves
        merge(nums, start, mid, end);
        return count;
    }

    private void merge(int nums[], int start, int mid, int end)
    {
        List<Integer> temp = new ArrayList<>();
        int i = start, j = mid +1;

        while(i <= mid && j <= end)
        {
            if(nums[i] <= nums[j])
            {
                temp.add(nums[i++]);
            }else{
                temp.add(nums[j++]);
            }
        }

        while(i <= mid)
        {
            temp.add(nums[i++]);
        }

        while(j <= end)
        {
            temp.add(nums[j++]);
        }
        for(int idx= start; idx <= end; idx++)
        {
            nums[idx] = temp.get(idx - start);
        }
    }
}