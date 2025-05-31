package dailyproblems.linerdp;

import java.util.Arrays;

public class MaximumLengthOfPairChain 
{
    public int findLongestChain(int[][] pairs) 
    {
        Arrays.sort(pairs,(a,b)->Integer.compare(a[1], b[1]));
        int ans=0;
        int curr=Integer.MIN_VALUE;
        for(var pair:pairs)
        {
            if(curr<pair[0])
            {
                curr=pair[1];
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MaximumLengthOfPairChain maximumLengthOfPairChain=new MaximumLengthOfPairChain();
        int arr[][]={{1,2},{7,8},{4,5}};
        System.out.println(maximumLengthOfPairChain.findLongestChain(arr));
    }
}
