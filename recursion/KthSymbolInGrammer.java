package recursion;

// https://leetcode.com/problems/k-th-symbol-in-grammar/description/
public class KthSymbolInGrammer 
{
    public int kthGrammar(int n, int k) 
    {
        if(n==1 && k==1)
            return 0;
        int mid=(int)Math.pow(2, n-1)/2;
        if(k<=mid)
            return kthGrammar(n-1, k);
        else
            return invert(kthGrammar(n-1, k-mid));   
    }

    int invert(int i)
    {
        return i==0?1:0;
    }

    public static void main(String[] args) {
        KthSymbolInGrammer kthSymbolInGrammer=new KthSymbolInGrammer();
        System.out.println(kthSymbolInGrammer.kthGrammar(6, 2));
    }
}
