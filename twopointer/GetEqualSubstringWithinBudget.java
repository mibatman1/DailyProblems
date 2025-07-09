package dailyproblems.twopointer;

public class GetEqualSubstringWithinBudget {

    public int equalSubstring(String s, String t, int maxCost) {
        int l=0, r=0, currCost=0, len=0;
        while(r<s.length())
        {
            currCost+=Math.abs(s.charAt(r)-t.charAt(r));
            while(currCost>maxCost)
            {
                currCost-=Math.abs(s.charAt(l)-t.charAt(l));
                l++;
            }
            len=Math.max(len,r-l+1);
            r++;
        }
        return len;      
    }

    public static void main(String[] args) {

    }
}
