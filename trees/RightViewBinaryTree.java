package dailyproblems.trees;

import java.util.ArrayList;
import java.util.List;

public class RightViewBinaryTree 
{
    private void right(TreeNode node, List<Integer>res, int lvl)
    {
        if(node==null)
            return;
        if(res.size()==lvl)
            res.add(node.val);
        right(node.right, res, lvl+1);
        right(node.left, res, lvl+1);
    }

    public List<Integer> rightSideView(TreeNode root) 
    {
        List<Integer>res=new ArrayList<>();
        right(root, res, 0);
        return res;
    }

    public static void main(String[] args) {
        
    }
}
