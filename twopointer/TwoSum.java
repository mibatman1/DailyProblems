package dailyproblems.twopointer;

// https://leetcode.com/problems/two-sum/
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int s=0, e=nums.length-1;
        while(s<=e)
        {
            if(nums[s]+nums[e]==target)
                return new int[]{s, e};
        }
        return null;
    }

    public static void main(String[] args) {
        TwoSum twoSum=new TwoSum();
        int arr[]={2,7,11,15};
        int target=9;
        var sum=twoSum.twoSum(arr, target);
        for(var a:sum)
            System.out.println(a);
    }
}
