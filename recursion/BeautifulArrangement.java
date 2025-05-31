package dailyproblems.recursion;

public class BeautifulArrangement 
{
    private int count=0;
    public int countArrangement(int n) 
    {
        boolean vis[]=new boolean[n+1];
        solve(n, 1, vis);
        return count;
    }

    private void solve(int n, int idx, boolean vis[])
    {
        if(idx>n)
        {
            count++;
            return;
        }
        for(var i=1;i<=n;i++)
        {
            if(!vis[i] && (idx%i==0 || i%idx==0))
            {
                vis[i]=true;
                solve(n, idx+1, vis);
                vis[i]=false;
            }
        }
    }

    public static void main(String[] args) {
        BeautifulArrangement beautifulArrangement=new BeautifulArrangement();
        System.out.println(beautifulArrangement.countArrangement(2));
    }
}
