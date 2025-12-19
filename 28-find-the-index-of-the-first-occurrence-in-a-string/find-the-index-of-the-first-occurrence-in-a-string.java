class Solution {
    public int strStr(String haystack, String needle) {
        
        int n = haystack.length();
        int m = needle.length();

        // empty needle should return 0
        if(m == 0)
        return 0;

        // Loop through haystack from index 0 to n-m
        // n-m because needle can't fit beyond this point
        for(int i=0; i<= n-m; i++)
        {
            int j =0;

            while(j <m && haystack.charAt(i+j) == needle.charAt(j))
            {
                j++;
            }
            
            // If we completed the whole needle, match found
            if(j == m) return i;
        }
        // If we reach here, needle was not found in haystack
        return -1;
    }
}