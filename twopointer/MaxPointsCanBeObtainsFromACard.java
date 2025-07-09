package dailyproblems.twopointer;

public class MaxPointsCanBeObtainsFromACard {

    public int maxScore(int[] cardPoints, int k) {
        int ls=0, rs=0, mx=0;
        for(var i=0;i<k;i++)
        {
            ls+=cardPoints[i];
        }
        mx=ls;
        var rdx=cardPoints.length-1;
        for(var i=k-1;i>=0;i--)
        {
            ls-=cardPoints[i];
            rs+=cardPoints[rdx];
            rdx--;
            mx=Math.max(mx, (ls+rs));
        }
        return mx;
    }

    public static void main(String[] args) {
        
    }
    
}
