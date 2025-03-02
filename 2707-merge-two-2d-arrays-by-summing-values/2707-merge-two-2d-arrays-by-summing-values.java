class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int i = 0, j = 0, k = 0;
        int[][] temp = new int[m + n][2];

        while (i < n || j < m) {
            if (i < n && j < m) {
                if (nums1[i][0] > nums2[j][0]) {
                    temp[k++] = new int[]{nums2[j][0], nums2[j][1]};
                    j++;
                } else if (nums1[i][0] < nums2[j][0]) {
                    temp[k++] = new int[]{nums1[i][0], nums1[i][1]};
                    i++;
                } else {
                    temp[k++] = new int[]{nums1[i][0], nums1[i][1] + nums2[j][1]};
                    i++;
                    j++;
                }
            } else if (i == n) {
                temp[k++] = new int[]{nums2[j][0], nums2[j][1]};
                j++;
            } else {
                temp[k++] = new int[]{nums1[i][0], nums1[i][1]};
                i++;
            }
        }

        // Copy only the valid elements
        int[][] res = new int[k][2];
        System.arraycopy(temp, 0, res, 0, k);
        return res;
    }
}