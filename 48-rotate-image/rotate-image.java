class Solution {
    public void rotate(int[][] matrix) {
        // O(n²),  O(1)
        int m = matrix.length;
        int n = m;

        // transpose a matrix
        for(int i=0; i<m; i++)
        {
            for(int j=i; j<n; j++)
            {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // reverse row in the matrix
        for(int i=0; i<m; i++)
        {
            reverse(matrix[i], 0, n-1);
        }
    }
    private void reverse(int row[], int start, int end)
    {
        while(start < end)
        {
            int temp = row[start];
            row[start] = row[end];
            row[end] = temp;
            start++;
            end--;
        }
    }
}