class Solution {
    public long largestSquareArea(int[][] bottom_left, int[][] top_right) {
        int n = bottom_left.length;
        long max_side = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int width = 
                    Math.min(top_right[i][0], top_right[j][0]) - 
                    Math.max(bottom_left[i][0], bottom_left[j][0]);
                int height = 
                    Math.min(top_right[i][1], top_right[j][1]) - 
                    Math.max(bottom_left[i][1], bottom_left[j][1]);
                int side = Math.min(width, height);

                max_side = Math.max(max_side, side);
            }
        }

        return max_side * max_side;
    }
}