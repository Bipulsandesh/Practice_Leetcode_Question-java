class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int a1 = function(tops, bottoms);
        int a2 = function(bottoms,tops);
        if(a1==-1) return a2;
        if(a2==-1) return a1;
    return Math.min(a1,a2);
    }
    public int function(int[] tops, int[] bottoms){
        int count = -1;
        int target = -1;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i : tops) {
            map.put(i, map.getOrDefault(i,0)+1);
            if(map.get(i)>count){
                target = i;
                count = map.get(i);
            }
        }
        int ans=0;
        for(int i=0;i<tops.length;i++){
            if(tops[i]==target) continue;
            else{
                if(bottoms[i]==target) ans++;
                else return -1;
            }
        }
    return ans;
    }
}