package dailyproblems.potd;

public class MinimizeXOR 
{
    public int minimizeXor(int num1, int num2) {
        int res=num1;
        int setBitCnt=Integer.bitCount(res);
        int targetBitCnt=Integer.bitCount(num2);
        int currentBitCount=0;
        while(setBitCnt<targetBitCnt)
        {
            if((res & (1<<currentBitCount))!=0)
            {
                res=res | (1<<currentBitCount);
                setBitCnt++;
            }
            currentBitCount++;
        }
        while(setBitCnt>targetBitCnt)
        {
            if((res & (1<<currentBitCount))==0)
            {
                res=res & ~(1<<currentBitCount);
                setBitCnt++;
            }
            currentBitCount++;
        }
        return res;
    }

    public static void main(String[] args) {
        MinimizeXOR minimizeXOR=new MinimizeXOR();
        System.out.println(minimizeXOR.minimizeXor(1, 12));
    }
}
