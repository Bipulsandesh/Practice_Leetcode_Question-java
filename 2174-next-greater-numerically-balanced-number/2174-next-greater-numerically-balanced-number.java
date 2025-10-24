class Solution {
    public int nextBeautifulNumber(int n) {
        n++;
        while(true){
            if(helper(n)) return n;
            n++;
        }
    }
    boolean helper(int n){
        HashMap<Integer, Integer> hm = new HashMap<>();
        while(n!=0){
            hm.put(n%10, hm.getOrDefault(n%10,0)+1);
            n/=10;
        }
        for(Map.Entry<Integer, Integer> m: hm.entrySet()){
            if(m.getKey()!=m.getValue()){
                return false;
            }
        }
        return true;
    }
}