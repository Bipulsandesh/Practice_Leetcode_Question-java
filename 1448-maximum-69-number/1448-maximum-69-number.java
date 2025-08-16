class Solution {
    public int maximum69Number (int num) {
        int tempnum=num;
        int index=0;
        int postindex=-1;
        while(tempnum!=0){
            int temp=tempnum%10;
            if(temp==6){
                postindex=index;
            }
            index++;
            tempnum/=10;
        }
        if(postindex==-1){
            return num;
        }
        return num+(3*(int)Math.pow(10,postindex));
    }
}