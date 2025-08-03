package dailyproblems.bst;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorder 
{
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer>mp=new HashMap<>();
        for(var i=0;i<inorder.length;i++)
            mp.put(inorder[i], i);
        return solve(preorder, 0, preorder.length-1, 0, mp);
    }
    
    private TreeNode solve(int preorder[], int start, int end, int preIdx, Map<Integer, Integer>mp)
    {
        if(start>end)
            return null;
        int rootVal=preorder[preIdx++];
        var rootNode=new TreeNode(rootVal);
        int rootIdx=mp.get(rootVal);
        rootNode.left=solve(preorder, start, rootIdx-1, preIdx, mp);
        rootNode.right=solve(preorder, rootIdx+1, end, preIdx, mp);
        return rootNode;
    }
}
