package dailyproblems.recursion;

// https://leetcode.com/problems/closest-dessert-cost/description/?envType=problem-list-v2&envId=backtracking
public class ClosestDesertCost 
{
    int res=0;
    int min=Integer.MAX_VALUE;
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        for(var arr:baseCosts)
        {
            solve(toppingCosts, target, arr, 0);
        }
        return res;
    }

    private void solve(int arr1[], int target, int cost, int idx)
    {
        if(idx==arr1.length)
        {
            int diff=Math.abs(target-cost);
            if(diff<=min)
            {
                if(diff<min)
                {
                    res=cost;
                    min=diff;
                }
                else
                {
                    if(cost<res)
                    {
                        res=cost;
                    }
                }
            }
            return;
        }
        solve(arr1, target, cost, idx+1);
        solve(arr1, target, cost+arr1[idx], idx+1);
        solve(arr1, target, cost+arr1[idx]*2, idx+1);
    }

    public static void main(String[] args) {
        ClosestDesertCost closestDesertCost=new ClosestDesertCost();
        int baseCosts[]={1,7};
        int toppingCosts[]={3, 4};
        int target=10;
        System.out.println(closestDesertCost.closestCost(baseCosts, toppingCosts, target));
    }
}
