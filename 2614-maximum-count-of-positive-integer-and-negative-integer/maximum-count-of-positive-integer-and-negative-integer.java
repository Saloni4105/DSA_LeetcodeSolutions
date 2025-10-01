class Solution {
    public int maximumCount(int[] nums) {
        int nCount =0;
        int pCount =0;

        for(int i=0; i<nums.length; i++)
        {
            if(nums[i] > 0)
            {
                pCount++;
            }
            else if(nums[i] < 0)
            {
                nCount++;
            }

        }
        return Math.max(pCount, nCount);
    }
}