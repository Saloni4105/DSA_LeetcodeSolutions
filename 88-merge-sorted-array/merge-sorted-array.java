class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // store first m elements of nums1
        int temp[] = new int[m];
        for(int i=0; i<m; i++)
        {
            temp[i]= nums1[i];
        }

        int i=0; //nums1
        int j=0; //nums2
        int k=0; //merged nums1

        // merge temp[] and nums2[] into nums1[]
        while(i < m && j < n)
        {
            if(temp[i] <= nums2[j])
            {
                nums1[k] = temp[i];
                i++;
            }else{
                nums1[k] = nums2[j];
                j++; 
            }
            k++;
        }

        // if elements remain in temp[]
        while(i < m)
        {
            nums1[k++] = temp[i++];
        }

        // if elements remain in nums2[]
        while(j < n)
        {
            nums1[k++] = nums2[j++];
        }
    }
}