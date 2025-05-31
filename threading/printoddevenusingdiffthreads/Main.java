package dailyproblems.threading.printoddevenusingdiffthreads;

public class Main 
{
    public static void main(String[] args) 
    {
        PrintNumbers printNumbers=new PrintNumbers();
        Thread oddThread=new Thread(()->
        {
            try {
                printNumbers.printOdd();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        },"Odd Thread");   
        
        Thread evenThread=new Thread(()->{
            try {
                printNumbers.printEven();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        },"Even Thread");

        oddThread.start();
        evenThread.start();
    }
}
