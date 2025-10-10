class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 1)
            return nums[0];

        if(n == 2)
            return Math.max(nums[0], nums[1]);

        //Case-1 (Take from 1st House - Hence skip the last house)
        int take_first_home = solve(nums, 0, n-2);
       

        //Case-2 (Take from 2nd House - Hence take the last house)
        int not_take_first_home = solve(nums, 1, n-1);

        return Math.max(take_first_home, not_take_first_home);
    }

    int solve(int nums[], int l, int r)
    {
        int prev =0;
        int prevPrev = 0;

        for(int i= l; i<=r; i++)
        {
            int skip = prev;
            int take = nums[i] + prevPrev;
            int temp = Math.max(skip, take);

            prevPrev = prev;
            prev = temp;
        }
        return prev;
    }
}