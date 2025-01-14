/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        //check for null input 
        if(root == null)return root;
        //make a queue for bfs
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        //going through the nodes in the queue
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i< size; i++){
                Node curr = queue.poll();
                //if the node is not the last node in its level
                if(i<size-1) curr.next = queue.peek();
                //add the left and right child to the queue
                if(curr.left != null) queue.add(curr.left);
                if(curr.right != null) queue.add(curr.right);
            }
        }
        return root;
    }
}

//Time and space complexity of O(n) where n is the number of nodes in the tree, 
//we need to check all the nodes at least once and we store them in a queue of size of n. 