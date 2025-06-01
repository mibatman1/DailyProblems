package dailyproblems.binarytree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

// https://leetcode.com/problems/validate-binary-tree-nodes/description/?envType=problem-list-v2&envId=mmbknbs2
public class ValidateBinaryTreeNodes 
{
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) 
    {
        int root=findRoot(leftChild, rightChild, n);
        if(root==-1)
            return false;
        Set<Integer>seen=new HashSet<>();
        Queue<Integer>q=new LinkedList<>();
        seen.add(root);
        q.add(root);
        while(!q.isEmpty())
        {
            var node=q.poll();
            int arr[]={leftChild[node], rightChild[node]};
            for(var child:arr)
            {
                if(child!=-1)
                {
                    if(seen.contains(child))
                        return false;
                    seen.add(child);
                    q.add(child);
                }
            }
        }
        return seen.size()==n;    
    }
    
    private int findRoot(int left[], int right[], int n)
    {
        Set<Integer>st=new HashSet<>();
        for(var l:left)
        {
            st.add(l);
        }
        for(var r:right)
        {
            st.add(r);
        }
        for(var i=0;i<n;i++)
        {
            if(!st.contains(i))
            {
                return i;
            }
        }
        return -1;
    }
}
