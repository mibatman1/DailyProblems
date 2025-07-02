package dailyproblems.twopointer;

import java.util.Arrays;

// https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/
public class NumberOfSubstringContainingAllThreeChar {

    public int numberOfSubstrings(String s) {
        int ls[]=new int[3];
        int cnt=0;
        Arrays.fill(ls, -1);
        for(var i=0;i<s.length();i++){
            ls[s.charAt(i)-'a']=i;
            if(ls[0]!=-1 && ls[1]!=-1 && ls[2]!=-1){
                cnt=cnt+(1+Math.min(ls[0], Math.min(ls[1], ls[2])));
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        NumberOfSubstringContainingAllThreeChar numberOfSubstringContainingAllThreeChar=new NumberOfSubstringContainingAllThreeChar();
        System.out.println(numberOfSubstringContainingAllThreeChar.numberOfSubstrings("abcabc"));
    }
}
