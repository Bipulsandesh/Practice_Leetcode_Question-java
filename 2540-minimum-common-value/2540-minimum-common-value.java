class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int s1 = 0;
        int s2 = 0;
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (nums1[n1 - 1] < nums2[0])
            return -1;
        if (nums2[n2 - 1] < nums1[0])
            return -1;
        while (s1 < n1 && s2 < n2) {
            if (nums1[s1] == nums2[s2])
                return nums1[s1];
            else if (nums1[s1] < nums2[s2])
                s1++;
            else
                s2++;
        }
        return -1;
    }
}