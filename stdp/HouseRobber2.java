package dailyproblems.stdp;

import java.util.ArrayList;
import java.util.List;

public class HouseRobber2 
{
    public int rob(int[] nums)
    {
        if(nums.length==1)
            return nums[0];
        List<Integer>ls=new ArrayList<>();
        List<Integer>ls1=new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            if(i!=0)
                ls.add(nums[i]);
            if(i!=nums.length-1)
                ls1.add(nums[i]);
        }
        return Math.max(solve(ls), solve(ls1));
    }

    // Tabulation + Space Optimization.
    private int solve(List<Integer>ls)
    {
        int prev1=ls.get(0);
        int prev2=0;
        for(int i=1;i<ls.size();i++)
        {
            int take=ls.get(i);
            if(i>1)
                take+=prev2;
            int notTake=prev1;
            int curr=Math.max(take, notTake);
            prev2=prev1;
            prev1=curr;
        }
        return prev1;
    }

    public static void main(String[] args) {
        int arr[]={1,2,3,1};
        HouseRobber2 houseRobber2=new HouseRobber2();
        System.out.println(houseRobber2.rob(arr));
    }
    
}
