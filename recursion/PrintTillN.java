package dailyproblems.recursion;

public class PrintTillN 
{
    private void print(int n, int i)
    {
        if(i>n)
            return;
        System.out.println(i);
        print(n, ++i);
    }

    public static void main(String[] args) 
    {
        PrintTillN printTillN=new PrintTillN();
        printTillN.print(50, 1);
    }
}
