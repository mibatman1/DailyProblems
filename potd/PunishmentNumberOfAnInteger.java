package dailyproblems.potd;

public class PunishmentNumberOfAnInteger 
{
    public int punishmentNumber(int n) {
        int sum=0;
        for(int i=1;i<=n;i++)
        {
            int prod=i*i;
            if(i-prod==0)
            {
                sum+=prod;
            }
            else
            {
                if(solve(prod, i))
                {
                    sum+=prod;
                }
            }
        }
        return sum;
    }

    private boolean solve(int n, int i)
    {
        if(i==n)
            return true;
        if(i<0 || n<i)
            return false;
        return solve(n/10, i-(n%10)) || solve(n/100, i-(n%100)) || solve(n/1000, i-(n%1000));
    }

    public static void main(String[] args) {
        int n=10;
        PunishmentNumberOfAnInteger punishmentNumberOfAnInteger=new PunishmentNumberOfAnInteger();
        System.out.println(punishmentNumberOfAnInteger.punishmentNumber(n));
    }
}
