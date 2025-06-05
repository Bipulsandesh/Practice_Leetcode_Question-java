class Solution {
    /*
       1. Group all character which are equivalent using DSU.
       2. Traverse baseStr, every Character of baseStr will belong to some group of character. Map that 
          character of baseStr to smallest character of that group.
    */
    int[] par;
    int[] rank;
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        initialize(26);
        for(int i=0;i<s1.length();i++){
            union(s1.charAt(i)-'a', s2.charAt(i)-'a');
        }
        
        ArrayList<Integer>[] list=new ArrayList[26];
        for(int i=0;i<26;i++)list[i]=new ArrayList<>();

        for(int i=0;i<26;i++){
           int par=find(i);
           list[par].add(i);
        }

        StringBuilder sb=new StringBuilder();
        for(int i=0;i<baseStr.length();i++){
            int ch=baseStr.charAt(i)-'a';
            for(int j=0;j<26;j++){
                if(list[j].contains(ch)){
                    sb.append((char)('a'+list[j].get(0)));
                }
            }
        }
        return sb.toString();
    }
    public void initialize(int n){
        par=new int[n];
        rank=new int[n];
        for(int i=0;i<n;i++){
            par[i]=i;
            rank[i]=1;
        }
    }
    public void union(int x,int y){
        int lx=find(x);
        int ly=find(y);
 
        if(lx!=ly){
            if(rank[lx]>rank[ly]){
              par[ly]=lx;
            }else if(rank[lx]<rank[ly]){
              par[lx]=ly;
            }else{
                par[lx]=ly;
                rank[ly]++;
            }
        }
    }
 
    public int find(int x){
        if(par[x]==x){
            return x;
        }
        int temp=find(par[x]);
        par[x]=temp;
        return temp;
    }
}