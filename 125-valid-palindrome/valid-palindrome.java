class Solution {
    public boolean isPalindrome(String s) {
        // two pointer
        // time - O(n), space - O(1)
        int left =0;
        int right = s.length() -1;

        while(left < right)
        {
            // ignoring special character
            while(left < right && !Character.isLetterOrDigit(s.charAt(left)))
            {
                left++;
            }
            // ignoring special character
            while(left < right && !Character.isLetterOrDigit(s.charAt(right)))
            {
                right--;
            }
            // compare by converting in lowercase
            if (Character.toLowerCase(s.charAt(left)) !=
                Character.toLowerCase(s.charAt(right)))
            {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}