class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int maxLIS = 1; //t(c) = O(n^2)

        int[] t = new int[n];
        Arrays.fill(t,1);

        for(int i =1; i < n; i++)
        {
            for(int j=0; j<i; j++)
            {
                if(nums[j] < nums[i])
                {
                    t[i] = Math.max(t[i], t[j] +1);
                   maxLIS = Math.max(maxLIS, t[i]);
                }
            }
        }
       return maxLIS;
    }
}