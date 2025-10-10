class Solution {

    // T(C) = O(n)
    int n;
    long[][] t; // DP table

    long solve(int idx, int[] nums, boolean isEven) {
        // Base case
        if (idx >= n) return 0;

        int evenFlag = isEven ? 1 : 0;

        // Return if already computed
        if (t[idx][evenFlag] != -1)
            return t[idx][evenFlag];

        // Option 1: skip current element
        long skip = solve(idx + 1, nums, isEven);

        // Option 2: take current (add or subtract based on parity)
        long val = nums[idx];
        if (!isEven) val = -val;

        long take = solve(idx + 1, nums, !isEven) + val;

        // Store and return max
        return t[idx][evenFlag] = Math.max(skip, take);
    }

    public long maxAlternatingSum(int[] nums) {
        n = nums.length;

        // ✅ Only allocate for n elements (not 1,000,000)
        t = new long[n][2];

        // Initialize DP with -1
        for (int i = 0; i < n; i++) {
            t[i][0] = -1;
            t[i][1] = -1;
        }

        // Start recursion (even index first)
        return solve(0, nums, true);
    }
}
