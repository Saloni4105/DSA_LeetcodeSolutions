class Solution {

    int n;
    int t[][];

    int solve(int pairs[][], int i, int P)
    {
        if(i >= n)
        {
            return 0; //base case
        }

        if(t[i][P+1] != -1)
        {
            return t[i][P+1];
        }

        int take = 0;
    
        // take ith element
        if(P == -1 || pairs[i][0] > pairs[P][1])
        {
            take = 1 + solve(pairs, i+1, i);
        }

        // skip ith element
        int skip = solve(pairs, i+1, P);

        return t[i][P+1] = Math.max(take, skip);
    }
    public int findLongestChain(int[][] pairs) {
        n = pairs.length;

        Arrays.sort(pairs, (a,b) -> Integer.compare(a[1], b[1]));
        t = new int[n][n+1];

        for(int i=0; i<n; i++)
        {
            Arrays.fill(t[i], -1);
        }
        return solve(pairs, 0, -1);
    }
}