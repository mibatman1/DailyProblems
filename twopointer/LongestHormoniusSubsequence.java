package dailyproblems.twopointer;

import java.util.Arrays;

public class LongestHormoniusSubsequence {

    public int findLHS(int[] nums) {
        int len=0, j=0;
        Arrays.sort(nums);
        for(var i=0;i<nums.length;i++)
        {
            while(nums[i]-nums[j]>1){
                j++;
            }
            if(nums[i]-nums[j]==1){
                len=Math.max(len, i-j+1);
            }
        }
        return len; 
    }

    public static void main(String[] args) {
        LongestHormoniusSubsequence longestHormoniusSubsequence=new LongestHormoniusSubsequence();
        System.out.println(longestHormoniusSubsequence.findLHS(new int[]{1,3,2,2,5,2,3,7}));
    }
}
