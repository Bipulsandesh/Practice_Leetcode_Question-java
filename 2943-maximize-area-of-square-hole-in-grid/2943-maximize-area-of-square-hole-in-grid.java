class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        int h=max(hBars);
        int v=max(vBars);
        int side=Math.min(h,v);
        return side*side;
    }
    public int max(int[] arr){
        int maxcons=1;
        int curr=1;
        for(int i=1;i<arr.length;i++){
            if(arr[i-1]+1==arr[i]){
                curr++;
                maxcons=Math.max(maxcons,curr);
            }
            else{
                curr=1;
            }
        }
        return maxcons+1;
    }
}