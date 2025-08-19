class Solution {
    public boolean search(int[] nums, int target) {
        return searchInArr(nums, target, 0, nums.length-1);
    }

    public static boolean searchInArr(int nums[], int target, int si, int ei)
    {
        if(si > ei)
        {
            return false;
        }
        int mid = si + (ei - si) / 2;

        if(nums[mid] == target)
        {
            return true;
        }

        if(nums[si] == nums[mid] && nums[mid] == nums[ei]) {
            return searchInArr(nums, target, si+1, ei-1);
        }

        if(nums[si] <= nums[mid])
        {
            if(nums[si] <= target && target <= nums[mid])
            {
                return searchInArr(nums, target, si, mid-1);
            }else{
                return searchInArr(nums, target, mid+1, ei);
            }
        }else
        {
            if(nums[mid] <= target && target <= nums[ei])
            {
                return searchInArr(nums, target, mid+1, ei);
            }else{
                return searchInArr(nums, target, si, mid-1);
            }
        }
    }
}