class Solution {

    int dp[] = new int[31];
    int solve(int n)
    {
        if(n <= 1)
        {
            return n;
        }

        if(dp[n] != -1)
        {
            return dp[n];
        }

        return dp[n] = solve(n-1) + solve(n-2);
    }

    public int fib(int n) {
        // Initialize all values to t to -1

        for(int i=0; i<dp.length; i++)
        {
            dp[i] = -1;
        }
        return solve(n);
    }
}