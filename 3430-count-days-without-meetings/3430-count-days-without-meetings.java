class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings,(a,b)->Integer.compare(a[0],b[0]));
        int result =0;
        int end = 0;
        for(int[]meet : meetings){
            int start = meet[0];
            int finish = meet[1];
            if(start>end){
                result +=start-end-1;    // last tday of satrt
            }
            end = Math.max(end,finish);
        }
        if(days>end){
            result+=days-end;
        }
        return result;
    }
}
