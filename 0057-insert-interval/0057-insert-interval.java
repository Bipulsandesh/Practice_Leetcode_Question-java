class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            // Case 1: Current interval is before the new interval
            if (intervals[i][1] < newInterval[0]) {
                res.add(intervals[i]);
            } 
            // Case 2: New interval is before the current interval
            else if (newInterval[1] < intervals[i][0]) {
                res.add(newInterval);

                // Add remaining intervals and return
                for (int j = i; j < intervals.length; j++) {
                    res.add(intervals[j]);
                }
                return res.toArray(new int[res.size()][]);
            } 
            // Case 3: Overlapping intervals, merge them
            else {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
        }

        // Add the final merged interval
        res.add(newInterval);
        return res.toArray(new int[res.size()][]);
    }
}