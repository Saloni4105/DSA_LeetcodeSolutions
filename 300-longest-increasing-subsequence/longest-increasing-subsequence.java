class Solution {
    int n;
    int t[][];
    int solve(int nums[], int i, int P)
    {
        if(i >= n)
        {
        return 0;
        }
        int take = 0;
        if(t[i][P+1] != -1)
        {
            return t[i][P+1];
        }

        // take ith element
        if(P == -1 || nums[i] > nums[P])
        {
            take = 1 + solve(nums, i+1, i);
        }

        // skip ith element
        int skip = solve(nums, i+1, P);

        return t[i][P + 1] = Math.max(take, skip);
    }
    
    public int lengthOfLIS(int[] nums) {
        n = nums.length;
        t = new int[n][n + 1]; 

        for(int i =0; i < n; i++)
        {
            Arrays.fill(t[i], -1);
        }
       return solve(nums, 0, -1); 
    }
}