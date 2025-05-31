package dailyproblems.stdp;

// https://www.geeksforgeeks.org/problems/partitions-with-given-difference/1
public class PartitionWithGivenDifference 
{
    int countPartitions(int[] arr, int d) 
    {
        int tSum=0;
        for(var it:arr)
            tSum+=it;
        if(tSum-d<0 || (tSum-d)%2!=0)
            return 0;
        return solve(arr, (tSum-d)/2, arr.length-1);
    }
    
    // Recursion
    int solve(int arr[], int tar, int idx)
    {
        if(idx==0)
        {
            if(tar==0 && arr[idx]==0)
                return 2;
            if(tar==0 || tar==arr[0])
                return 1;
            return 0;
        }
        int pick=0;
        if(arr[idx]<=tar)
            pick=solve(arr, tar-arr[idx], idx-1);
        int notPick=solve(arr, tar, idx-1);
        return pick+notPick;
    }

    public static void main(String[] args) {
        int arr[]={1,1,1,1};
        int d=0;
        PartitionWithGivenDifference partitionWithGivenDifference=new PartitionWithGivenDifference();
        System.out.println(partitionWithGivenDifference.countPartitions(arr, d));
    }
}
