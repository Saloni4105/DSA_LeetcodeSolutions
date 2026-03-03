class Solution {
    public void reverseString(char[] s) {
        StringBuilder sb = new StringBuilder();

        // append char from end to start
        for(int i=s.length-1; i>=0; i--)
        {
            sb.append(s[i]);
        }

        // copy back to orginal array
        for(int i=0; i<s.length; i++)
        {
            s[i] = sb.charAt(i);
        }
    }
}