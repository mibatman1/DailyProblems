package dailyproblems.potd;

public class MaximumCountOfPositiveOrNegativeNumber 
{
    public int maximumCount(int[] nums) 
    {
        int pCount=0, nCount=0;
        for(var num:nums)
        {
            if(num>0)
                pCount++;
            else if(num<0)
                nCount++;
        }
        return Math.max(pCount, nCount);
    }
}
