class Solution {
    public int[] avoidFlood(int[] rains) {
        int ans[] = new int[rains.length];
        int last[] = new int[rains.length];
        HashMap<Integer,Integer> track = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=rains.length-1; i>=0 ; i--){
            int num = rains[i];
            if(num==0){
                continue;
            }
            if(track.containsKey(num)){
                last[i] = track.get(num);
            }
            else{
                last[i] = -1;
            }
            track.put(num,i);
        }

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<rains.length;i++){
            if(rains[i]!=0){
                int num = rains[i];
                if(map.containsKey(num)){
                    
                    return new int[0];
                }

                map.put(num,1);
                ans[i] = -1;
                if(last[i]!=-1){pq.add(last[i]);}
            }
            else{

                if(map.size()==0 || i==rains.length-1){
                    ans[i] = 1;
                    continue; 
                }

                if(pq.isEmpty()){
                    ans[i] = 1;
                    continue;
                }
                int idx = pq.poll();
                if(idx==-1){
                    ans[i] = 1;
                }
                else{
                    ans[i] = rains[idx];
                    map.remove(rains[idx]);
                }
                
               
            }
        }

        return ans;
    }
}