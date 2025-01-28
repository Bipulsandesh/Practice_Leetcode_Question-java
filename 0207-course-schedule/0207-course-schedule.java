class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
       int indegree[] = new int[n];
       List<List<Integer>> graph = new ArrayList<>();

        for(int i=0;i<n;i++) graph.add(new ArrayList<>());
       for(int row[] : prerequisites){
           graph.get(row[1]).add(row[0]);
           indegree[row[0]]++;
       }

       int count =0;
       Queue<Integer> q = new LinkedList<>();
       for(int i=0;i<n;i++){
           if(indegree[i] ==0) q.add(i);
       }

       while(!q.isEmpty()){
           int node = q.poll();
           count++;
           for(int adjNode : graph.get(node)){
               indegree[adjNode]--;
               if(indegree[adjNode] ==0) q.add(adjNode);
           }
       }
        return count == n;

    }
}