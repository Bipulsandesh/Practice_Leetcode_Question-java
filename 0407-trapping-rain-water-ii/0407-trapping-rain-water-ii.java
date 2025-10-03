class Solution {
    private boolean isValid(int x,int y,int n,int m){
        return x>=0&&y>=0&&x<n&&y<m;
    }
    public int trapRainWater(int[][] heightMap) {
        int n=heightMap.length,m=heightMap[0].length;
        int water=0;
        PriorityQueue<int[]> pq=new PriorityQueue<>((x,y)->x[0]-y[0]);
        boolean[][] vis=new boolean[n][m];
        for(int i=0;i<n;i++){
            pq.offer(new int[]{heightMap[i][0],i,0});
            pq.offer(new int[]{heightMap[i][m-1],i,m-1});
            vis[i][0]=true;
            vis[i][m-1]=true;
        }
        for(int i=1;i<m-1;i++){
            pq.offer(new int[]{heightMap[0][i],0,i});
            pq.offer(new int[]{heightMap[n-1][i],n-1,i});
            vis[0][i]=true;
            vis[n-1][i]=true;
        }
        int[] a={1,-1,0,0};
        int[] b={0,0,1,-1};
        while(!pq.isEmpty()){
            int[] temp=pq.poll();
            for(int i=0;i<4;i++){
                int x=temp[1]+a[i];
                int y=temp[2]+b[i];
                if(isValid(x,y,n,m)&&!vis[x][y]){
                    water+=Math.max(0,temp[0]-heightMap[x][y]);
                    pq.offer(new int[]{Math.max(temp[0],heightMap[x][y]),x,y});
                    vis[x][y]=true;
                }
            }
        }
        return water;
    }
}