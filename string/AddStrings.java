package dailyproblems.string;

public class AddStrings 
{
    public String addStrings(String num1, String num2) {
        int l1=num1.length();
        int l2=num2.length();
        int carry=0;
        StringBuilder res=new StringBuilder();
        while(l1>=0 || l2>=0 || carry!=0)
        {
            int a=(l1>=0)?num1.charAt(l1--)-'0':0;
            int b=(l2>=0)?num2.charAt(l2--)-'0':0;
            int sum=a+b+carry;
            int digi=sum%10;
            carry=sum/10;
            res.append(digi);
        }
        return res.reverse().toString();
        
    }
    public static void main(String[] args) 
    {
        
    }
}
