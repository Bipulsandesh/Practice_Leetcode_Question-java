class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int res = Integer.MAX_VALUE, m = mat.length, n = mat[0].length, max = 0;
        for (int a : arr)
            max = Math.max(a, max);
        int[] freq = new int[max + 1];
        for (int i = 0; i < arr.length; i++) {
            freq[arr[i]] = i;
        }
        for (int i = 0; i < m; i++) {
            int lastNumIdx = Integer.MIN_VALUE;
            for (int j = 0; j < n; j++) {
                int idx = freq[mat[i][j]];
                lastNumIdx = Math.max(lastNumIdx, idx);
            }
            res = Math.min(res, lastNumIdx);
        }
        for (int j = 0; j < n; j++) {
            int lastNumIdx = Integer.MIN_VALUE;
            for (int i = 0; i < m; i++) {
                int idx = freq[mat[i][j]];
                lastNumIdx = Math.max(lastNumIdx, idx);
            }
            res = Math.min(res, lastNumIdx);
        }
        return res;
    }
}