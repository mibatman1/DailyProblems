package dailyproblems.twopointerlatest;

// https://leetcode.com/problems/container-with-most-water/description/
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int l=0, r=height.length-1;
        int max=Integer.MIN_VALUE;
        while(l<r)
        {
            int w=r-l;
            int h=Math.min(height[l], height[r]);
            var area=w*h;
            max=Math.max(max, area);
            if(height[l]>height[r])
                r--;
            else
                l++;
        }
        return max;
    }

    public static void main(String[] args) {
        
    }
}
