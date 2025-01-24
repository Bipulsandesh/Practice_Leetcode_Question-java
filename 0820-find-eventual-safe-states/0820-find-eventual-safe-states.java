class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        //approach:
            //we need to do a dfs on every single node if it has not been visited before.
            //We start a dfs on an arbitraty node
                //if we already know a node does not lead to a safe node or a terminal node, we use that result and do not DFS further into the graph
                    //we can use a byte array. 0 means no result stored, 1 means it does not lead to terminal/safe node, and 2 means all paths from this node lead to terminal/safe node.
                //if we encounter a node already in the stack (i.e currently processing path), then it is a cycle and we return false. (we keep track using a boolean array)
                //if we reach a terminal node, add it to the result and return true
                //if we reach a node where the dfs on all the neighbors returns true (they all are safe or terminal nodes), then we add this current node to the results and return true
                    //otherwise return false since not all paths from here lead to a safe/terminal node
            //do this dfs on every node if it does not have a result stored (not dealt with yet)
        
        //OPTIMIZATION: Since we are checking if a stored state for a node is 1, or 2 and quitting the function if it is, then the only other possibility to continue exploring the dfs is if the stored state is 0 (i.e unvisited)
            //what we can do then is use the storedState[i] = -1 to indicate that the ith node is currently in the stack (path being explored) and use that to detect cycles. This eliminated the boolean array inStack. 
                //we are able to do this as it does not interfere with the stored states 1 and 2, since the function doesn't continue on if that's the case.
        
        //storedStates array is memoization. 0 = unvisited, 1 = doesnt lead to terminal/safe node, 2 = leads to terminal/safe node, -1 = inStack
        //also, instead of adding to an arraylist directly in the recursion, and worrying about sorting it at the end, we can simply indicate if a node is safe in a boolean array of size n, and at the end, do an O(n) operation from 0 to n-1 and add them into our arraylist afterwards. This makes sure we add elements in ascending order. This also brings our time complexity from O(nlogn) back to O(n).

        byte[] storedStates = new byte[graph.length]; 
        boolean[] isSafe = new boolean[graph.length];
        List<Integer> safeNodes = new ArrayList<>();
        for(int i = 0; i < graph.length; i++)
            if(storedStates[i] == 0)
                dfs(i, storedStates, graph, isSafe);
        
        for(int i = 0; i < isSafe.length; i++)
            if(isSafe[i]) safeNodes.add(i);

        return safeNodes;

    }

    public boolean dfs(int curr, byte[] storedStates, int[][] graph, boolean[] isSafe){
        if(storedStates[curr] == 2) return true;
        if(storedStates[curr] == 1) return false;
        if(storedStates[curr] == -1) return false;

        int[] neighbors = graph[curr];
        storedStates[curr] = -1;
        for(int neighbor: neighbors){
            if(!dfs(neighbor, storedStates, graph, isSafe)){
                storedStates[curr] = 1;
                return false;
            }
        
        }
        storedStates[curr] = 2; //nothing went wrong
        isSafe[curr] = true;
        return true;
    }
}