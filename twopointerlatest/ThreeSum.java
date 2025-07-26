package dailyproblems.twopointerlatest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum 
{
    public List<List<Integer>> threeSum(int[] nums) 
    {
        List<List<Integer>>res=new ArrayList<>();
        Arrays.sort(nums);
        for(var i=0;i<nums.length-2;i++)
        {
            if(i>0 && nums[i]==nums[i-1])
                continue;
            int l=i+1;
            int r=nums.length-1;
            while(l<r)
            {
                int sum=nums[i]+nums[l]+nums[r];
                if(sum==0)
                {
                    res.add(Arrays.asList(i,l,r));
                    l++;
                    r--;
                }
                else if(sum<0)
                {
                    l++;
                }
                else
                {
                    r--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) 
    {

    }    
}
