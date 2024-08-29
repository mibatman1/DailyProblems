package string;

public class RotateString 
{
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length())
            return false;
        return (s+s).contains(goal); 
    }

    public static void main(String[] args) {
        RotateString rotateString=new RotateString();
        System.out.println(rotateString.rotateString("abcde", "abcce"));
    }
}
