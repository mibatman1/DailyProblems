package dailyproblems.twopointerlatest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum 
{
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>>res=new ArrayList<>();
        Arrays.sort(nums);
        for(var i=0;i<nums.length;i++)
        {
            if(i>0 && nums[i]==nums[i-1])
                continue;
            for(var j=i+1;j<nums.length;j++)
            {
                if(j>i+1 && nums[j]==nums[j-1])
                    continue;
                int l=j+1;
                int r=nums.length-1;
                while(l<r)
                {
                    long sum=nums[i]+nums[j]+nums[l]+nums[r];
                    if(sum<target)
                    {
                        l++;
                    }
                    else if(sum==target)
                    {
                        res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        while(l<r && nums[l]==nums[l+1])
                            l++;
                        while(l<r && nums[r]==nums[r-1])
                            r--;
                        l++;
                        r--;
                    }
                    else
                        r--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        
    }    
}
