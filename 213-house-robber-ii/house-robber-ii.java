class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int t[] = new int[n+1];

        if(n == 1)
            return nums[0];

        int result1 = 0;
        int result2 = 0;

        //Case-1 (Take from 1st House - Hence skip the last house)
        t[0] = 0;
        for(int i=1; i<= n-1; i++)
        {
            int skip = t[i-1];
            int steal = nums[i-1] + (i-2 >= 0 ? t[i-2] : 0);
            t[i] = Math.max(skip, steal);
        }
        result1 = t[n-1];
       

        //Case-2 (Take from 2nd House - Hence take the last house)
        Arrays.fill(t, 0);
        t[0] = 0;
        t[1] = 0;
        for(int i=2; i<=n; i++)
        {
            int skip = t[i-1];
            int steal = nums[i-1] + (i-2 >= 0 ? t[i-2] : 0);
             t[i] = Math.max(skip, steal);
        }
        result2 = t[n];

        return Math.max(result1, result2);
    }
}