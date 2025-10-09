class Solution {
    
    public int rob(int[] nums) {
        int n = nums.length;
       if(n == 1)
            return nums[0];

            int t[] = new int[n+1]; // t[i] = max profit till house i
            t[0] = 0;
            t[1] = nums[0];

            for(int i=2; i<= n; i++)
            {
                int skip = t[i-1];
                int steal = nums[i-1] + t[i-2];
                t[i] = Math.max(skip, steal);

                /*
                SKIP  : If we skip this house,  then profit till previous house = t[i-1]
                STEAL : If we steal this house, then we can't take prev profit, we can take till (i-2)th house profit = t[i-2]
            */
            }
        return t[n];
    }
}