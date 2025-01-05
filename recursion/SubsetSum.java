package recursion;

import java.util.ArrayList;

public class SubsetSum 
{
    public ArrayList<Integer> subsetSums(int[] arr) 
    {
        ArrayList<Integer>ans=new ArrayList<>();
        solve(arr, ans, 0, 0);
        return ans;
    }

    private void solve(int arr[], ArrayList<Integer>ans, int idx, int sum)
    {
        if(idx==arr.length)
        {
            ans.add(sum);
            return;
        }
        solve(arr, ans, idx+1, sum+arr[idx]);
        solve(arr, ans, idx+1, sum);
    }

    public static void main(String[] args) {
        int arr[]={2,3};
        SubsetSum subsetSum=new SubsetSum();
        System.out.println(subsetSum.subsetSums(arr));
    }
}
