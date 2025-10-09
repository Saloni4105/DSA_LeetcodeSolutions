class Solution {
    int t[] = new int[101];
    public int rob(int[] nums) {
        int n = nums.length;
        Arrays.fill(t, -1);
        return solve(nums, 0, n);
    }

    int solve(int nums[], int i, int n)
    {
        if(i >= n)
        {
            return 0;
        }

        // If already computed, return stored value
        if (t[i] != -1)
            return t[i];

        // Option 1: Rob current house and move to i+2
        int steal = nums[i] + solve(nums, i+2, n);

        // Option 2: Skip current house and move to i+1
        int skip = solve(nums, i+1, n);

        return t[i] = Math.max(steal, skip);
    }
}