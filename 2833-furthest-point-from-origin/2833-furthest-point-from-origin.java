class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int left = 0;
        int right = 0;
        int extra = 0;

        for(char m : moves.toCharArray()) {
            if(m == 'L') left++;
            else if(m == 'R') right++;
            else extra++;
        }

        return Math.abs(left - right) + extra;
    }
}