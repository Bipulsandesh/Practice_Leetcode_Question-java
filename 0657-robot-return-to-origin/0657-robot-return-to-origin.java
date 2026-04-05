class Solution {
    public boolean judgeCircle(String moves) {
        if(moves.length()%2!=0) return false;
        int updown=0,rightleft=0;
        for(char c:moves.toCharArray()){
            switch(c){
                case 'R':rightleft++;
                break;
                case 'L':rightleft--;
                break;
                case 'U':updown++;
                break;
                case 'D':updown--;
            }
        }
        return updown==0 && rightleft==0;
    }
}