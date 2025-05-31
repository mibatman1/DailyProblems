package dailyproblems.recursion;

public class FairDistributionOfCookies 
{
    private int ans=Integer.MAX_VALUE;
    public int distributeCookies(int[] cookies, int k) 
    {
        solve(cookies, 0, k, new int[k]);
        return ans;
    }

    void solve(int arr[], int idx, int k, int arr1[])
    {
        if(idx==arr.length)
        {
            var max=0;
            for(var num:arr1)
            {
                max=Math.max(max,num);
            }
            ans=Math.min(max, ans);
            return;
        }
        for(var i=0;i<k;i++)
        {
            arr1[i]+=arr[idx];
            solve(arr, idx+1, k, arr1);
            arr1[i]-=arr[idx];
        }
    }

    public static void main(String[] args) {
        FairDistributionOfCookies fairDistributionOfCookies=new FairDistributionOfCookies();
        int arr[]=new int[]{8,15,10,20,8};
        int k=2;
        System.out.println(fairDistributionOfCookies.distributeCookies(arr, k));
    }
}
