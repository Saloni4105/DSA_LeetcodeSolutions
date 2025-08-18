class Solution {
    public int search(int[] nums, int target) {
        int ans = searchInArr(nums, target, 0, nums.length-1);
        return ans;
    }

    public static int searchInArr(int nums[], int target, int si, int ei)
    {
        if(si > ei)
        {
            return -1;
        }
        int mid = si + (ei - si) / 2;

        if(nums[mid] == target)
        {
            return mid;
        }
        if(nums[si] <= nums[mid])
        {
            if(nums[si] <= target && target <= nums[mid])
            {
                return searchInArr(nums, target, si , mid-1);
            }
            else
            {
                return searchInArr(nums, target, mid+1, ei);
            }
        }
        else
        {
            if(nums[mid]<= target && target <= nums[ei])
            {
                return searchInArr(nums, target, mid+1, ei);
            }
            else
            {
                return searchInArr(nums, target, si, mid-1);
            }
        }
    }
}