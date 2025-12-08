class Solution {
    public int countTriples(int n) {
      HashSet<Integer>set=new HashSet<>();
        for(int i=1;i<=n;i++)set.add(i*i);
        int count=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(set.contains((i*i)+(j*j)))count++;
            }
        }
        return count;
    }
}