class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if(a[1] != b[1]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });

        int a = -1, b = -1;
        int cnt = 0;
        for(int i = 0; i < intervals.length; i++){
            if(a >= intervals[i][0] && b <= intervals[i][1]) continue;
            else if(b <= intervals[i][1] && b >= intervals[i][0]){
                if(b == intervals[i][1]) a = b - 1;
                else{
                    a = b;
                    b = intervals[i][1];
                }

                cnt++;
            }
            else{
                b = intervals[i][1];
                a = b - 1;
                cnt += 2;
            }
        }

        return cnt;
    }
}