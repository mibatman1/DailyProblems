package dailyproblems.linerdp;

public class BestTimeToSellAndBuyStock 
{
    public int maxProfit(int[] prices) {
        int min=Integer.MAX_VALUE;
        int profit=0;
        for(int i=0;i<prices.length;i++)
        {
            min=Math.min(min, prices[i]);
            profit=Math.max(profit, prices[i]-min);
        }
        return profit;
    }

    public static void main(String[] args) {
        int arr[]={7,1,5,3,6,4};
        BestTimeToSellAndBuyStock bestTimeToSellAndBuyStock=new BestTimeToSellAndBuyStock();
        System.out.println(bestTimeToSellAndBuyStock.maxProfit(arr));
    }
    
}
