class Solution {

    public boolean check(int[] nums) {

        // Counts inversion points
        int count = 0;

        // Traverse array
        for (int i = 0; i < nums.length - 1; i++) {

            /*
             * Inversion found
             * rotation point detected
             */

            if (nums[i] > nums[i + 1]) {

                count++;
            }
        }

        /*
         * Check circular boundary
         * between last and first element
         */

        if (nums[nums.length - 1] > nums[0]) {

            count++;
        }

        // Valid only if at most one inversion exists
        return count <= 1;
    }
}