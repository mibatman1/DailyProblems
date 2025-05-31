package dailyproblems.recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum 
{
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>res=new ArrayList<>();
        solve(candidates, 0, target, res, new ArrayList<>());
        return res;
    }

    private void solve(int arr[], int start, int target, List<List<Integer>>res, List<Integer>temp)
    {
        if(target<0)
            return;
        if(target==0)
        {
            res.add(new ArrayList<>(temp));
        }
        for(int i=start;i<arr.length;i++)
        {
            temp.add(arr[i]);            
            solve(arr, i, target-arr[i], res, temp);
            temp.removeLast();
        }
    }

    public static void main(String[] args) 
    {
        int arr[]={2,3,6,7};
        int num=7;
        CombinationSum combinationSum=new CombinationSum();
        System.out.println(combinationSum.combinationSum(arr, num));
    }
}
