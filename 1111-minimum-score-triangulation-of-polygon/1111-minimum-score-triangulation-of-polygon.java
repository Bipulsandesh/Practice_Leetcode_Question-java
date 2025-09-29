class Solution {
    public int minScoreTriangulation(int[] values) {
       int n= values.length;
       Integer[][] reference=new Integer[n][n];
       return evaluate(values,0,n-1,reference);
    }
    private static int evaluate(int[] values,int i,int j,Integer[][] reference){
        int mini=Integer.MAX_VALUE;
        if(j-i<2) return 0;
        if(reference[i][j] !=null) return reference[i][j];
        for(int k=i+1;k<j;k++){
            int answer=values[i]*values[j]*values[k]+
            evaluate(values,i,k,reference)+
            evaluate(values,k,j,reference);
            if(answer<mini) mini=answer;
        }
        reference[i][j]=mini;
        return reference[i][j];
    }
 
    
}