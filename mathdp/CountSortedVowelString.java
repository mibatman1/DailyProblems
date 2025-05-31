package dailyproblems.mathdp;

// https://leetcode.com/problems/count-sorted-vowel-strings/description/?envType=problem-list-v2&envId=m221vove
public class CountSortedVowelString 
{
    private int a=1, e=1, i=1, o=1, u=1;
    public int countVowelStrings(int n) {
        return solve(n);
    }

    private int solve(int n)
    {
        for(var j=1;j<n;j++)
        {
            a=a+e+i+o+u;
            e=e+i+o+u;
            i=i+o+u;
            o=o+u;
        }
        return a+e+i+o+u;
    }

    public static void main(String[] args) {
        CountSortedVowelString countSortedVowelString=new CountSortedVowelString();
        System.out.println(countSortedVowelString.countVowelStrings(2));
    }
}
