class Solution {
    public int uniquePaths(int m, int n) {
        // O(m*n) O(m*n) Using rec +memo
        int t[][] = new int[m][n];
        for(int row[] : t)
        {
            Arrays.fill(row, -1);
        }
        return solve(0 , 0, m, n, t);
    }

    int solve(int i, int j, int m, int n, int t[][])
    {
        // Reached the bottom-right cell
        if(i == m-1 && j == n-1)
        {
            return 1;
        }

        // Out of bounds
        if(i < 0 || i >= m || j < 0 || j >= n)
        {
            return 0;
        }

        // If already computed, return the stored result
        if(t[i][j] != -1)
        {
            return t[i][j];
        }
        int right = solve(i, j+1, m, n, t);
        int down = solve(i+1, j, m, n, t);

        return t[i][j] = right + down;
    }
}