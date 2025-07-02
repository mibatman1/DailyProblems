package dailyproblems.twopointer;

import java.util.Arrays;

// https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/?envType=daily-question&envId=2025-06-29
public class NumberOfSubSeqSatisfyTheSum {

    public int numSubseq(int[] nums, int target) {
        int s=0, e=nums.length-1;
        int mod=100000007;
        int cnt=0;
        Arrays.sort(nums);
        int pow[]=new int[nums.length];
        pow[0]=1;
        for(var i=1;i<nums.length;i++)
        {
            pow[i]=(pow[i-1]*2)%mod;
        }
        while(s<=e)
        {
            if(nums[s]+nums[e]<=target)
            {
                cnt=(cnt+pow[e-s])%mod;
                s++;
            }
            else
            {
                e--;
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        
    }
}
