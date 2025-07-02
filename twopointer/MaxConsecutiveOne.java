package dailyproblems.twopointer;

public class MaxConsecutiveOne {

    public int findMaxConsecutiveOnes(int[] nums) {
        int r=0, l=0, len=0;
        while(r<nums.length){
            if(nums[r]==1){
                len=Math.max(len, r-l+1);
            }
            else{
                l=r+1;
            }
            r++;
        }
        return len;
    }

    public static void main(String[] args) {
        MaxConsecutiveOne maxConsecutiveOne=new MaxConsecutiveOne();
        System.out.println(maxConsecutiveOne.findMaxConsecutiveOnes(new int[]{1,0,1,1,0,1}));
    }
}
