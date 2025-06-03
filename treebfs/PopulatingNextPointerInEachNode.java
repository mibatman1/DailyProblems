package dailyproblems.treebfs;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextPointerInEachNode 
{
    public Node connect(Node root)
    {
        Queue<Node>q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            var s=q.size();
            for(var i=0;i<s;i++)
            {
                var node=q.poll();
                if(i==s-1)
                    node.next=null;
                else
                    node.next=q.peek();
                if(node.left!=null)
                    q.add(node.left);
                if(node.right!=null)
                    q.add(node.right);
            }
        }
        return root;
    }    
}
