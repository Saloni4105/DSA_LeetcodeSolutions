class Solution {
    public double myPow(double x, int n) {

        long N = n;
        if (N < 0) 
        {
            x = 1 / x;
            N = -N;
        }
        if(N == 0)
        {
            return 1.0;
        }
        double halfPowerSq = myPow(x, (int)(N/2));
        double powSq = halfPowerSq  * halfPowerSq ;

        if(N % 2 != 0)
        {
            powSq = x * powSq;
        }
        return powSq;
    }
}