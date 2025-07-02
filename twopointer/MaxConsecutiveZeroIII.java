package dailyproblems.twopointer;

public class MaxConsecutiveZeroIII {

    public int longestOnes(int[] nums, int k) {
        int r=0, l=0, z=0, len=0;
        while(r<nums.length){
            if(nums[r]==0){
                z++;
            }
            if(z>k){
                if(nums[l]==0){
                    z--;
                }
                l++;
            }
            if(z<=k){
                len=Math.max(len, r-l+1);
            }
            r++;
        }
        return len;
    }

    public static void main(String[] args) {
        MaxConsecutiveZeroIII maxConsecutiveZeroIII=new MaxConsecutiveZeroIII();
        System.out.println(maxConsecutiveZeroIII.longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0},2));
    }
}
