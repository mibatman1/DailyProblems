package dailyproblems.recursion;

// https://leetcode.com/problems/minimum-number-of-work-sessions-to-finish-the-tasks/description/?envType=problem-list-v2&envId=backtracking
public class MinimumNumberOfWorkSession 
{
    int res=0;
    public int minSessions(int[] tasks, int sessionTime) {
        solve(tasks, sessionTime, 0, 0);
        return res;
    }

    private void solve(int task[], int sessionTime, int count, int idx)
    {
        if(count==sessionTime)
        {
            res++;
            count=0;
            return;
        }
        while(count<sessionTime && idx<task.length)
            solve(task, sessionTime, count+task[idx], idx+1);
    }

    public static void main(String[] args) {
        int task[]={1,2,3};
        int sessionTime=3;
        MinimumNumberOfWorkSession minimumNumberOfWorkSession=new MinimumNumberOfWorkSession();
        System.out.println(minimumNumberOfWorkSession.minSessions(task, sessionTime));
    }
}
