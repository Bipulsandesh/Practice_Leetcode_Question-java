class Solution {
    public String makeLargestSpecial(String s) {
        int n=s.length();
        ArrayList<String> list=new ArrayList<>();
        int count=0,start=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            // balance like parentheses
            if(ch=='1'){
                count++;
            }
            else{
                count--;
            }
            // one complete special substring found
            if(count==0){
                String inner = makeLargestSpecial(
                        s.substring(start+1,i)
                );
                list.add("1"+inner+"0"); // wrap with outer 1 and 0
                start=i+1;
            }
        }
        // larger blocks first for lexicographically largest result
        Collections.sort(list,Collections.reverseOrder());
        // build final answer
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<list.size();i++){
            ans.append(list.get(i));
        }
        return ans.toString();
    }
}