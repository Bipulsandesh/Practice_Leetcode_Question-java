class Solution {
    public int minimumCost(int[] cost) {
        // Sort in ascending order
        Arrays.sort(cost);

        int total = 0;

        /*
        * Traverse from largest
        * towards smallest
        */

        for (int i = cost.length - 1;
            i >= 0;
            i -= 3) {

            // Most expensive candy
            total += cost[i];

            // Second most expensive
            if (i - 1 >= 0) {

                total += cost[i - 1];
            }

            /*
            * i - 2 is free
            * so skip it
            */
        }

        return total;
    }
}