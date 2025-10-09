class Solution {

    int  t[] = new int[46];
    public int climbStairs(int n) {

        for(int i=0; i<=n; i++)
        {
            t[i] = -1;
        }
        return solve(n);
    }

    int solve(int n)
    {

        if(n < 0)
        {
            return 0;
        }

        if( n == 0)
            return 1;

        if(t[n] != -1)
            return t[n];

        int One_step = solve(n-1);
        int two_step = solve(n-2);

        return t[n] = One_step + two_step;
    }
}