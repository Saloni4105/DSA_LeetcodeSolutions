class Solution {

    int t[] = new int[101];
    int solve(int nums[], int i, int n)
    {
        if(i > n)
        {
            return 0;
        }

        // if already computed, return stored value
        if(t[i] != -1)
        {
            return t[i];
        }

        // Option 1: Rob current house and move to i+2
        int steal = nums[i] + solve(nums, i+2, n);

        // Option 2: Skip current house and move to i+1
        int skip = solve(nums, i+1, n);

        return t[i] = Math.max(steal, skip);
    }

    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 1)
            return nums[0];

        if(n == 2)
            return Math.max(nums[0], nums[1]);

        Arrays.fill(t, -1);

        // case 1: take 0th index
        int take0 = solve(nums, 0, n-2);

        Arrays.fill(t, -1);

        // case 2 : take 1st index house
        int take1 = solve(nums, 1, n-1);

        return Math.max(take0, take1);
    }
}