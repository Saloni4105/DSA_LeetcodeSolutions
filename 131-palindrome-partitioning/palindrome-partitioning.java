class Solution {
        // T(C) = O(2 ^n)
        public void solve(String s, int i, List<String> currPartition, boolean t[][], List<List<String>> result)
    {
        if(i == s.length())
        {
            result.add(new ArrayList<>(currPartition));
            return;
        }

        for(int j=i; j<s.length();j++)
        {
            if(t[i][j])
            {
            currPartition.add(s.substring(i, j+1));
            solve(s, j+1, currPartition, t, result);
            currPartition.remove(currPartition.size()-1);
            }
        }
    }   

    public List<List<String>> partition(String s)
    {
        int n = s.length();
        boolean t[][] = new boolean[n][n];

        // Initialize the DP table for palindromic substrings
        // t[i][j] = true -> s[i...j] is a palindrome

        for(int i=0; i<n; ++i)
        {
            t[i][i] = true; //substring of a single character is always a palindrome
        }

        for(int L=2; L<=n; ++L)
        {
        for(int i=0; i<n-L+1; ++i)
        {
            int j = i+L-1;
            if(s.charAt(i) == s.charAt(j))
            {
                if(L == 2)
                {
                t[i][j] = true;
                }else{
                    t[i][j] = t[i+1][j-1];
                }
            }
        }
    }
    List<List<String>> result = new ArrayList<>();
    List<String> currPartition = new ArrayList<>();
    solve(s, 0, currPartition, t, result);

    return result;
    }
}