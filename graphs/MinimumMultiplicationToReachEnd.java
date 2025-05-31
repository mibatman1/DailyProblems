package dailyproblems.graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// https://www.geeksforgeeks.org/problems/minimum-multiplications-to-reach-end/1
public class MinimumMultiplicationToReachEnd 
{
    int minimumMultiplications(int[] arr, int start, int end) 
    {
        Queue<Pair>q=new LinkedList<>();
        q.add(new Pair(start,0));
        int dist[]=new int[100000];
        Arrays.fill(dist, (int)1e9);
        dist[start]=0;
        while(!q.isEmpty())
        {
            var node=q.poll();
            var first=node.first;
            var second=node.second;
            for(int i=0;i<arr.length;i++)
            {
                int num=(arr[i]*first)%100000;
                if(second+1<dist[num])
                {
                    dist[num]=second+1;
                    if(num==end)
                        return second+1;
                    q.add(new Pair(num, second+1));
                }
            }
        }
        return -1;
    }
}

class Pair
{
    int first;
    int second;
    Pair(int first, int second)
    {
        this.first=first;
        this.second=second;
    }
}
