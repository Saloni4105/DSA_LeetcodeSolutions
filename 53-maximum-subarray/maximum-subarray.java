class Solution {
    public int maxSubArray(int[] nums) {
        // O(n) , O(1)
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        for(int i=0; i<nums.length; i++)
        {
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(currSum, maxSum);
        }
        return maxSum;
    }
}