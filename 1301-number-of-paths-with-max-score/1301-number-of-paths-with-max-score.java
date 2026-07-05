class Solution {
    static int n;
    static List<String>board;
    static Pair [][]dp;
    static int MOD=1_000_000_007;
    public int[] pathsWithMaxScore(List<String> board) {
        n=board.size();
        this.board=board;
        dp=new Pair[n][n];
        Pair ans=solve(0,0);
        if(ans.score<0){
            return new int[]{0,0};
        }
        return new int[]{ans.score,ans.path};
    }
    public Pair solve(int i,int j){
        if(i>=n||j>=n){
            return new Pair(-1000000000,0);
        }
        char ch=board.get(i).charAt(j);
        if(ch=='X'){
            return new Pair(-1000000000,0);
        }
        if(i==n-1&&j==n-1){
            return new Pair(0,1);
        }
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        Pair down=solve(i+1,j);
        Pair right=solve(i,j+1);
        Pair diag=solve(i+1,j+1);
        int max=Math.max(down.score,Math.max(right.score,diag.score));
        long ways=0;
        if(down.score==max){
            ways+=down.path;
        }
        if(right.score==max){
            ways+=right.path;
        }
        if(diag.score==max){
            ways+=diag.path;
        }
        ways%=MOD;
        int val=0;
        if(ch!='E'&&ch!='S'){
            val=ch-'0';
        }
        return dp[i][j]=new Pair(max+val,(int)ways);
    }
    public class Pair{
        int score;
        int path;
        Pair(int score,int path){
            this.score=score;
            this.path=path;
        }
    }
}