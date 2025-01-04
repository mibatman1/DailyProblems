package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class DijkastraPQ 
{
    ArrayList<Integer> dijkstra(ArrayList<ArrayList<Pair>> adj, int src) 
    {
        PriorityQueue<Pair>q=new PriorityQueue<Pair>((x,y)->x.first-y.first);
        Integer dist[]=new Integer[adj.size()];
        ArrayList<Integer>res=new ArrayList<>();
        dist[src]=0;
        q.add(new Pair(0, src));
        while(!q.isEmpty())
        {
            var node=q.poll();
            var d=node.first;
            var no=node.second;
            for(var it:adj.get(no))
            {
                var edgew=it.first;
                var adjNode=it.second;
                if(edgew+d<dist[adjNode])
                {
                    dist[adjNode]=edgew+d;
                    q.add(new Pair(dist[adjNode],adjNode));
                }
            }
        }
        Collections.addAll(res,dist);
        return res;
    }

    public static void main(String[] args) {
        DijkastraPQ dijkastraPQ=new DijkastraPQ();
        int[][][] nestedArray = {
            {{1, 1}, {2, 6}},
            {{2, 3}, {0, 1}},
            {{1, 3}, {0, 6}}
        };

        // Create the nested ArrayList
        ArrayList<ArrayList<ArrayList<Integer>>> nestedList = new ArrayList<>();

        // Convert the 3D array to an ArrayList
        for (int[][] array2D : nestedArray) {
            ArrayList<ArrayList<Integer>> list2D = new ArrayList<>();
            for (int[] array1D : array2D) {
                list2D.add(new ArrayList<>(Arrays.asList(array1D[0], array1D[1])));
            }
            nestedList.add(list2D);
        }
        dijkastraPQ.dijkstra(null, 0);
    }
}

class Pair {
    int first, second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
