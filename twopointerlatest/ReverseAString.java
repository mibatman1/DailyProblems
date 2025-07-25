package dailyproblems.twopointerlatest;

// https://leetcode.com/problems/reverse-string/description/
public class ReverseAString 
{
    public void reverseString(char[] s) {
        int l=0, r=s.length-1;
        while(l<r)
        {
            char ch=s[l];
            s[l]=s[r];
            s[r]=ch;
            l++;
            r--;
        }   
    }
    public static void main(String[] args) {
        System.out.println("This is something out of the world");
    }    
}
