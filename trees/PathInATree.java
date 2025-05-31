package dailyproblems.trees;

import java.util.ArrayList;

//https://www.naukri.com/code360/problems/path-in-a-tree_3843990
public class PathInATree 
{
    private boolean getPath(TreeNode node, ArrayList<Integer>res, int x)
    {
        if(node==null)
            return false;
        res.add(node.val);
        if(x==node.val)
            return true;
        if(getPath(node.left, res,x)==true)
            return true;
        if(getPath(node.right, res,x))
            return true;
        res.remove(res.size()-1);
        return false;
    }

    public ArrayList<Integer> pathInATree(TreeNode root, int x) 
    {
        ArrayList<Integer>res=new ArrayList<>();
        getPath(root, res, x);
        return res;
    }
}
