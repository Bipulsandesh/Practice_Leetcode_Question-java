class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
         List<List<Integer>> res=new ArrayList<>();
        findcomb(k,n,res,1,new ArrayList<>());
        return res;
    }
     private static void findcomb(int k,int target,List<List<Integer>>res,int start,List<Integer>comb){
        
        if(target<0 || comb.size()>k){
            return;
        }
        if(target==0 && comb.size()==k){
            res.add(new ArrayList<>(comb));
            return;
        }
        for(int i=start;i<=9;i++){
            
            comb.add(i);
            
            findcomb(k, target-i, res, i+1, comb);
            comb.remove(comb.size()-1);
        }
    }
}