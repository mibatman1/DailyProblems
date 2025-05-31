package dailyproblems.graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;

public class MinimumCostOfAPathWithMinimumRoads 
{
    public int minimumCost(int[] start, int[] target, int[][] specialRoads) 
    {
        int n=specialRoads.length;
        int m=specialRoads[0].length;
        Map<Integer, HashSet<Integer>>mp=new HashMap<>();
        PriorityQueue<Pair>q=new PriorityQueue<>((x,y)->x.c-y.c);
        q.add(new Pair(start[0], start[1], 0));
        int dx=target[0];
        int dy=target[1];
        while(!q.isEmpty())
        {
            var node=q.poll();
            int cux=node.x;
            int cuy=node.y;

            if(mp.containsKey(cux) && mp.get(cux).contains(cuy))
                continue;
            if(!mp.containsKey(cux))
                mp.put(cux, new HashSet<>());
            mp.get(cux).add(cuy);
            if(cux==dx && cuy==dy)
                return node.c;
            int d=node.c+Math.abs(cux-dx)+Math.abs(cuy-dy);
            q.add(new Pair(cux, cuy, d));
            for(int i=0;i<specialRoads.length;i++)
            {
                int x=specialRoads[i][0];
                int y=specialRoads[i][1];
                int x1=specialRoads[i][2];
                int y1=specialRoads[i][3];
                int c=specialRoads[i][4];
                if(mp.containsKey(x1) && mp.get(x1).contains(y1))
                    continue;
                q.add(new Pair(x1, y1, node.c+c+Math.abs(x-x1)+Math.abs(y-y1)));
            }
        }
        return -1;    
    }
}

class Pair
{
    int x,y,c;
    public Pair(int x, int y, int c)
    {
        this.x=x;
        this.y=y;
        this.c=c;
    }
}
