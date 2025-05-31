package dailyproblems.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CloneGraph 
{
    public Node cloneGraph(Node node) {
        if(node==null)
            return null;
        Queue<Node>q=new LinkedList<>();
        Map<Node, Node>mp=new HashMap<>();
        q.add(node);
        mp.put(node, node);
        dfs(node, mp);
        while(!q.isEmpty())
        {
            var nod=q.poll();
            for(var it:nod.neighbors)
            {
                if(!mp.containsKey(it))
                {
                    q.add(it);
                    mp.put(it, new Node(it.val));
                }
                mp.get(nod).neighbors.add(mp.get(it));
            }
        }
        return mp.get(node);
    }

    // DFS
    void dfs(Node node, Map<Node, Node>mp)
    {
        Node nod=new Node(node.val);
        mp.put(node, nod);
        for(var it:node.neighbors)
        {
            if(!mp.containsKey(it))
            {
                dfs(it, mp);
            }
            mp.get(node).neighbors.add(mp.get(nod));
        }
    }
}

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}