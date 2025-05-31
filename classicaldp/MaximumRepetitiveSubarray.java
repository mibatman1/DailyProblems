package dailyproblems.classicaldp;

import java.util.Arrays;

public class MaximumRepetitiveSubarray 
{
    private int max=0;
    public int findLength(int[] nums1, int[] nums2) {
        int dp[][]=new int[nums1.length+1][nums2.length+1];
        for(var it:dp)
            Arrays.fill(it, -1);
        solve(nums1, nums2, nums1.length-1, nums2.length-1, dp); 
        return max;
    }

    private int solve(int a[], int b[], int i, int j, int dp[][])
    {
        if(i<0 || j<0)
            return 0;

        if(dp[i][j]!=-1)
            return dp[i][j];
        
        int len=0;
        if(a[i]==b[j])
            len=1+solve(a, b, i-1, j-1, dp);
        max=Math.max(max, len);
        solve(a, b, i-1, j, dp);
        solve(a, b, i, j-1, dp);
        return dp[i][j]=len;        
    }

    public static void main(String[] args) {
        int arr[]={0,0,0,0,0};
        int arr1[]={0,0,0,0,0};
        MaximumRepetitiveSubarray maximumRepetitiveSubarray=new MaximumRepetitiveSubarray();
        System.out.println(maximumRepetitiveSubarray.findLength(arr, arr1));
    }
    
}
