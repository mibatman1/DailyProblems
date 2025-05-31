package dailyproblems.minmaxdp;

public class TwoKeysBoard 
{
    public int minSteps(int n) {
        if(n==1)
            return 0;
        return 1+solve(1, 1, n);
        
    }

    private int solve(int currLen, int pasteLen, int n)
    {
        if(currLen==n)
            return 0;
        if(currLen>n)
            return 100000;
        int copyAndPaste=2+solve(currLen*2, currLen, n);
        int paste=1+solve(currLen+pasteLen, pasteLen, n);
        return Math.min(copyAndPaste, paste);
    }

    public static void main(String[] args) {
        TwoKeysBoard twoKeysBoard=new TwoKeysBoard();
        int n=3;
        System.out.println(twoKeysBoard.minSteps(n));
    }
    
}
