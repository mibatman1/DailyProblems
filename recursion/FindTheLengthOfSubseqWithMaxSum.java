package dailyproblems.recursion;

import java.util.Arrays;

public class FindTheLengthOfSubseqWithMaxSum 
{
    public int[] maxSubsequence(int[] nums, int k) {
        int val[][]=new int[nums.length][2];
        for(var i=0;i<nums.length;i++)
        {
            val[i][0]=nums[i];
            val[i][1]=i;
        }
        Arrays.sort(val, (x, y)->Integer.compare(y[0],x[0]));
        Arrays.sort(val, 0, k, (x, y)->Integer.compare(x[1], y[1]));
        int res[]=new int[k];
        for(var i=0;i<k;i++)
        {
            res[i]=val[i][0];
        }
        return res; 
    }

    public static void main(String[] args) {
        int arr[]={2,1,3,3};
        int k=2;
        FindTheLengthOfSubseqWithMaxSum findTheLengthOfSubseqWithMaxSum=new FindTheLengthOfSubseqWithMaxSum();
        var a=findTheLengthOfSubseqWithMaxSum.maxSubsequence(arr, k);
        for(var s:a)
            System.out.println(s);
    }
}
