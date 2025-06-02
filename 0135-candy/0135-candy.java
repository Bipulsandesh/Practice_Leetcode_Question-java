class Solution {
    public static int candy(int[] ratings) {
        int n=ratings.length; // Number of children
        int idx=1; // Start from the second child
        int candies=1; // First child gets at least 1 candy

        while(idx<n) {
            if(ratings[idx]==ratings[idx-1]) {
                candies+=1; // Equal rating, give 1 candy
                idx++;
                continue;
            }

            int up=1; // Start of increasing sequence
            while(idx<n&&ratings[idx]>ratings[idx-1]) {
                up++;
                candies+=up;
                idx++;
            }

            int down=1; // Start of decreasing sequence
            while(idx<n&&ratings[idx]<ratings[idx-1]) {
                candies+=down;
                down++;
                idx++;
            }

            // If the decreasing sequence is longer than the increasing one,
            // we need to give extra to the peak child
            if(down>up) {
                candies+=down-up;
            }
        }

        return candies;
    }
}