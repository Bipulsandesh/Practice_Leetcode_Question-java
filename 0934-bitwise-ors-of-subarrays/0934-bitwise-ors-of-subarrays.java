class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        int n =arr.length;
        Set<Integer> prev = new HashSet<>();
        Set<Integer> res = new HashSet<>();
        for(int num: arr){
            Set<Integer> curr = new HashSet<>();
            curr.add(num);
            for(int p: prev) curr.add(p | num);
            prev = curr;
            res.addAll(curr);
        }

        return res.size();


    }
}