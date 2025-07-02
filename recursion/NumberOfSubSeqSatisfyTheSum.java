package dailyproblems.recursion;

// https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/description/?envType=daily-question&envId=2025-06-29
public class NumberOfSubSeqSatisfyTheSum 
{
    private int cnt=0;
    private int mod=1_000_000_007;
    public int numSubseq(int[] nums, int target) {
        int s=0, e=nums.length-1;
        int pow2[]=new int[nums.length+1];
        pow2[0]=1;
        for(var i=1;i<=nums.length;i++)
        {
            pow2[i]=(pow2[i-1]*2)%mod;
        }
        while(s<=e)
        {
            if(nums[s]+nums[e]<=target)
            {
                cnt+=pow2[e-s]%mod;
                s++;
            }
            else{
                e--;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int arr[]={3,3,6,8};
        int tar=10;
        NumberOfSubSeqSatisfyTheSum numberOfSubSeqSatisfyTheSum=new NumberOfSubSeqSatisfyTheSum();
        System.out.println(numberOfSubSeqSatisfyTheSum.numSubseq(arr, tar));
    }
}
