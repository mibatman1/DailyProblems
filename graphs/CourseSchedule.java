package dailyproblems.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/course-schedule/
public class CourseSchedule 
{
    public boolean canFinish(int numCourses, int[][] prerequisites) 
    {
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++)
        {
            adj.add(new ArrayList<>());
        }
        int m=prerequisites.length;
        for(int i=0;i<m;i++)
        {
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        int inDeg[]=new int[m];
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<m;i++)
        {
            for(var it:adj.get(i))
            {
                if(inDeg[it]==0)
                {
                    q.add(it);
                }
            }
        }
        int cnt=0;
        while(!q.isEmpty())
        {
            var node=q.poll();
            cnt++;
            for(var it:adj.get(node))
            {
                inDeg[it]--;
                if(inDeg[it]==0)
                {
                    cnt++;
                }
            }
        }
        if(cnt==m)
            return false;
        return true;
    }
}
