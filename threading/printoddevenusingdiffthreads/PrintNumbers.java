package dailyproblems.threading.printoddevenusingdiffthreads;

// Print Odd Even Number using Different Threads
public class PrintNumbers
{
    private int numbers=1;
    private final int MAX=100;

    public synchronized void printEven() throws InterruptedException
    {
        while(numbers<=MAX)
        {
            while(numbers%2!=0) 
            {
                wait();
            }
            System.out.println("By 1st"+numbers);
            numbers++;
            notify();
        }
    }

    public synchronized void printOdd() throws InterruptedException
    {
        while(numbers<MAX)
        {
            while(numbers%2==0)
            {
                wait();
            }
            System.out.println("By 2nd"+numbers);
            numbers++;
            notify();
        }
    }
}
