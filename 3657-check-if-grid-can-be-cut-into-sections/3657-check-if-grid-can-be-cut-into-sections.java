class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        Arrays.sort(rectangles, Comparator.comparingInt(a -> a[0]));
        int line = rectangles[0][2];
        int sum = 0;
        for(int i=1; i<rectangles.length; i++) {
            if(line <= rectangles[i][0]) {
                sum++;
            }
            line = Math.max(line, rectangles[i][2]);
        }
        if(sum >= 2) return true;
        Arrays.sort(rectangles, Comparator.comparingInt(a -> a[1]));
        sum = 0;
        line = rectangles[0][3];
        for(int i=1; i<rectangles.length; i++) {
            if(line <= rectangles[i][1]) {
                sum++;
            }
            line = Math.max(line, rectangles[i][3]);
        }
        return (sum >= 2) ? true : false;
    }
}

