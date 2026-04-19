class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int maxDist = Integer.MIN_VALUE, n = nums1.length, m = nums2.length;

        int i = 0, j = 0;
        while (i < n && j < m) {
            if (i <= j && nums1[i] <= nums2[j]) {
                int dist = j - i;
                maxDist = Math.max(maxDist, dist);
                j++;
            } else {
                if (i <= j && nums1[i] > nums2[j]) {
                    i++;
                } else if (i > j) {
                    j++;
                }
            }
        }

        return maxDist == Integer.MIN_VALUE ? 0 : maxDist;
    }
}