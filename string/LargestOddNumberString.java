package string;

public class LargestOddNumberString 
{
    public String largestOddNumber(String num) 
    {
        int len=num.length();
        char ch=num.charAt(len-1);
        int n=ch-'0';
        int j=0,l=0,m=0;
        if(n%2!=0)
        {
            return num;
        }
        for(int i=0;i<len;i++)
        {
            char c=num.charAt(i);
            if((c-'0')%2==0)
            {
                m++;
                continue;
            }
            else
            {
                l=i;
            }
        }
        if(m==len)
            return "";
        return num.substring(j,l+1);
    }

    public static void main(String[] args) {
        LargestOddNumberString largestOddNumberString=new LargestOddNumberString();
        System.out.println(largestOddNumberString.largestOddNumber("52"));
    }
}
