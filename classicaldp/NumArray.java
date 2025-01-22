package classicaldp;

public class NumArray
{
    private int nums[];
    public NumArray(int[] nums) {
        this.nums=nums;
    }
    
    public int sumRange(int left, int right) {
        int res=0;
        for(int i=left;i<=right;i++)
        {
            res+=nums[i];
        }
        return res;
    }
}