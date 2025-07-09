class Solution {
    public int n;
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime){
    n = startTime.length;
    //1 gap between t = 0 and start of 1st meeting, (n - 1) gaps between consecutive meetings, 1 gap between last meeting and t = eventTime. So total = 1 + (n - 1) + 1 = n + 1
    int[][] events = new int[n][2];
    for(int i = 0; i < n; i++){
        events[i] = new int[]{startTime[i], endTime[i]};
    }
    //Sort by start time
    Arrays.sort(events, (a, b) -> {
        if(a[0] == b[0]) return a[1] - b[1];
        return a[0] - b[0];
    });
    int[] gaps = new int[n + 1];  
    //Before the first meeting
    gaps[0] = events[0][0];
    for(int i = 1; i < n; i++){
        //Between consecutive meetings
        gaps[i] = events[i][0] - events[i - 1][1];
    }
    //After the last meeting
    gaps[n] = eventTime - events[n - 1][1];
    int windowSize = k + 1, maxFreeTime = 0, sum = 0, start = 0;
    for(int end = 0; end <= n; end++){
        sum += gaps[end];
        while(start < end && end - start + 1 > windowSize){
            sum -= gaps[start];
            start++;
        }
        maxFreeTime = Math.max(sum, maxFreeTime);
    }
    return maxFreeTime;
    }
}