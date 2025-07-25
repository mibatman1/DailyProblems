package dailyproblems.trees;

// https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/?envType=problem-list-v2&envId=m22zq90v
public class PopulatingNextNode 
{
    public Node connect(Node root) {
        if(root==null)
        {
            return null;
        }
        if(root.left!=null)
        {
            root.left.next=root.right;
        }
        if(root.right!=null && root.next!=null)
        {
            root.right.next=root.next.left;
        }
        connect(root.right);
        connect(root.left);
        return root;
    }
}

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