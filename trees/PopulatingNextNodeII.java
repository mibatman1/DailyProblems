package dailyproblems.trees;

public class PopulatingNextNodeII 
{
    public Node connect(Node root) {
        if(root==null)
            return null;
        if(root.left!=null)
        {
            if(root.right==null)
                if(root.next!=null && root.next.left!=null)
                    root.left.next=root.next.left;
                else if(root.next!=null && root.next.right!=null)
                    root.left.next=root.next.right;
                else
                    root.left.next=null;
            else
                root.left.next=root.right;
        }
        if(root.right!=null && root.next!=null)
        {
            if(root.next.left==null && root.next.right!=null)
                root.right.next=root.next.right;
            else if(root.next.left==null && root.next.right==null)
                root.right.next=null;
        }
        connect(root.left);
        connect(root.right);
        return root;
    } 
}
