package dailyproblems.recursion;

public class PrintNTo1 
{
    private void print(int n, int i)
    {
        if(n<i)
            return;
        System.out.println(n);
        print(n-1, i);
    }
    public static void main(String[] args) {
        PrintNTo1 printNTo1=new PrintNTo1();
        printNTo1.print(50,1);
    }
}
