package dailyproblems.potd;

public class ClearDigits 
{
    public String clearDigits(String s) 
    {

        StringBuilder str=new StringBuilder();
        for(int i=0;i<s.length();i++)
        {
            if(Character.isDigit(s.charAt(i)) && str.length()!=0)
            {
                str.setLength(str.length()-1);
            }
            else
            {
                str.append(s.charAt(i));
            }
        }
        return str.toString();   
    }

    public static void main(String[] args) {
        String str="cb67bb";
        ClearDigits clearDigits=new ClearDigits();
        System.out.println(clearDigits.clearDigits(str));
    }
}
