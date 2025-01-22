package graphs;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        //find indegree of all nodes leaves will be having 1 and inner nodes 2 
        //so we will be inserting the to queue and decreasing the indgree as we removed 
        // leaves the indegree will be 1 for the next inner nodes we will continue till, atmost 2 nodes
        // are present in the queue.


        // why 2 nodes? conisider examples in description when num of nodes is odd there is one node 
        //and two nodes when even number of nodes are present

        
        List<List<Integer>> graph= new ArrayList<>();
        int[] indegree= new int[n]; 
        List<Integer> res= new ArrayList<>();
        if (n == 1) return Collections.singletonList(0);
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<Integer>());
        }

        for(int[] edge:edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
            indegree[edge[0]]++;
            indegree[edge[1]]++;
        }

        Queue<Integer> q= new ArrayDeque<>();
        
        for(int i=0;i<n;i++){
            if(indegree[i]==1){
                q.add(i);
                indegree[i]--;
            }
        }

        while(!q.isEmpty()){
            res.clear();//at each level we noeed only that nodes so remove nodes
            int size=q.size();
            for(int i=0;i<size;i++){
                int curr=q.poll();
                res.add(curr);
                for(int child:graph.get(curr)){
                 indegree[child]--;
                 if(indegree[child]==1){
                    q.add(child);
                 }

                }
            }

        }
        return res;
         
    }

    public static void main(String[] args) {
        int arr[][]={{1,0},{1,2},{1,3}};
        int n=4;
        MinimumHeightTrees minimumHeightTrees=new MinimumHeightTrees();
        System.out.println(minimumHeightTrees.findMinHeightTrees(n, arr));
    }
}