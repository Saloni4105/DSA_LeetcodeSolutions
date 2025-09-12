class Solution {
    public boolean isPalindrome(String s) {
        // convert to lowercase and remove non-alphanumeric
        String str = s.toLowerCase().replaceAll("[^a-z0-9]", "");

        // check palindrome
        int n= str.length();
        for(int j= 0; j< n/2; j++)
        {
            if( str.charAt(j) != str.charAt(n-1-j))
            {
                return false;
            }
        }
        return true;
    }
}