class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int max1 = -1;
        int max2 = -1;

        int i=0, j=0;

        for(int count =0; count <= (m+n)/2; count++)
        {
            max1 = max2;
            if (i < m && (j >= n || nums1[i] <= nums2[j]))
            {
                max2 = nums1[i];
                i++;
            }
            else
            {
                max2 = nums2[j];
                j++;
            }
        }
        if((m+n)%2 == 1)
        {
            return max2; //odd
        }
        return (max1+max2)/2.0; //even
    }
}