package trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class IterativePreorder 
{
    public List<Integer> preorderTraversal(TreeNode root) 
    {
        if(root==null)
        {
            return new ArrayList<>();
        }
        Deque<TreeNode>st=new ArrayDeque<>();
        List<Integer>res=new ArrayList<>();
        st.push(root);
        while(!st.isEmpty())
        {
            var node=st.pop();
            res.add(node.val);
            if(node.right!=null)
                st.push(node.right);
            if(node.left!=null)
                st.push(node.left);
        }
        return res;
    }

    public static void main(String[] args) {
        
    }
}
