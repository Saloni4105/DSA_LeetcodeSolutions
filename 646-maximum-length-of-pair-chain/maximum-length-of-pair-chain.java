class Solution {
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        
        Arrays.sort(pairs, (a,b) -> Integer.compare(a[1], b[1]));
        int maxLIS = 1;
        
        int t[] = new int[n];
        Arrays.fill(t, 1);

        for(int i=1; i<n; i++)
        {
            for(int j=0; j<i; j++)
            {
                if(pairs[j][1] < pairs[i][0])
                {
                    t[i] = Math.max(t[i], t[j] + 1);
                    maxLIS = Math.max(maxLIS, t[i]);
                }
            }
        }
        return maxLIS;
    }
}