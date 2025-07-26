package dailyproblems.twopointerlatest;

public class CountSpecialQuadplets 
{
    public int countQuadruplets(int[] nums) {
        int count=0;
        for(var i=0;i<nums.length;i++)
        {
            for(var j=i+1;j<nums.length;j++)
            {
                for(var k=j+1;k<nums.length;k++)
                {
                    for(var l=k+1;l<nums.length;l++)
                    {
                        if(nums[i]+nums[j]+nums[k]==nums[l])
                            count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        
    }    
}
