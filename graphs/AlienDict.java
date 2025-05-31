package dailyproblems.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://www.geeksforgeeks.org/problems/alien-dictionary/1
public class AlienDict 
{
    // Points to be noted
    // if the string s1 is greater than s2 then dict is not possible
    // because s2 would always be 1st as its shorter than s1.
    // And if there is any cyclic dependency or cycle then dict is not possible.
    private List<Integer>topo(int v, List<List<Integer>>adj)
    {
        int inDeg[]=new int[v];
        for(int i=0;i<v;i++)
        {
            for(var it:adj.get(i))
            {
                inDeg[it]++;
            }
        }
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<v;i++)
        {
            if(inDeg[i]==0)
            {
                q.add(i);
            }
        }
        List<Integer>res=new ArrayList<>();
        while(!q.isEmpty())
        {
            var node=q.poll();
            res.add(node);
            for(var it:adj.get(node))
            {
                inDeg[it]--;
                if(inDeg[it]==0)
                    q.add(it);
            }
        }
        return res;
    }

    public String findOrder(String[] dict, int k) 
    {
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<k;i++)
        {
            adj.add(new ArrayList<>());
        }
        int m=dict.length;
        for(int i=0;i<m-1;i++)
        {
            String s1=dict[i];
            String s2=dict[i+1];
            int l=Math.min(s1.length(), s2.length());
            for(int j=0;j<l;j++)
            {
                if(s1.charAt(j)!=s2.charAt(j))
                {
                    adj.get(s1.charAt(j)-'a').add(s2.charAt(j)-'a');
                    break;
                }
            }
        }
        List<Integer>res=topo(k, adj);
        String r="";
        for(var it:res)
        {
            r+=r+(char)(it-(int)'a');
        }
        return r;
    }

    public static void main(String[] args) {
        AlienDict alienDict=new AlienDict();
        String s[]={"bcc","abc","cda"};
        System.out.println(alienDict.findOrder(s, 4));
    }
}
