package dailyproblems.recursion;

import java.util.Arrays;

public class MaxCompatibilitySum 
{
    private int max=0;
    public int maxCompatibilitySum(int[][] students, int[][] mentors) 
    {
        boolean vis[]=new boolean[students.length];
        Arrays.fill(vis, false);
        solve(students, mentors, 0, vis, 0);
        return max;
    }

    private void solve(int arr[][], int arr1[][], int idx, boolean vis[], int score)
    {
        if(idx>=arr.length)
        {
            max=Math.max(score, max);
            return;
        }
        for(var i=0;i<arr.length;i++)
        {
            if(!vis[i])
            {
                vis[i]=true;
                solve(arr, arr1, idx+1, vis, score+helper(arr[idx], arr1[i]));
                vis[i]=false;
            }
        }
    }

    private int helper(int arr[], int arr1[])
    {
        int count=0;
        for(var i=0;i<arr.length;i++)
        {
            if(arr[i]==arr1[i])
            {
                count++;
            }
        }
        return count;
    }
    
    public static void main(String[] args) 
    {
        int student[][]={{1,1,0},{1,0,1},{0,0,1}};
        int mentors[][]={{1,0,0},{0,0,1},{1,1,0}};
        MaxCompatibilitySum maxCompatibilitySum=new MaxCompatibilitySum();
        System.out.println(maxCompatibilitySum.maxCompatibilitySum(student, mentors));    
    }
}
