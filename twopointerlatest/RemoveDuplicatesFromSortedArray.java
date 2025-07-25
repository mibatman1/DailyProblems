package dailyproblems.twopointerlatest;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array/
public class RemoveDuplicatesFromSortedArray 
{
    public int removeDuplicates(int[] nums) 
    {
        int a=1;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]!=nums[i-1])
                nums[a++]=nums[i];
        }
        return a;
    }

    public static void main(String[] args) {
        
    }    
}
