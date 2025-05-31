package dailyproblems.classicaldp;

// Important- Kadane Algo
public class MaximumSubArrayWithOneDeletion 
{
    public int maximumSum(int[] arr) 
    {
        int pD=0, pND=arr[0], max=arr[0];
        for(int i=1;i<arr.length;i++)
        {
            pD=Math.max(pND, pD+arr[i]);
            pND=Math.max(pND+arr[i], arr[i]);
            int curr=Math.max(pD, pND);
            max=Math.max(max, curr);
        }
        return max;   
    }
}
