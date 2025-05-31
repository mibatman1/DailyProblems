package dailyproblems.threading.completablefutureexample;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample 
{
    public static void main(String[] args) 
    {
        CompletableFuture<String>future=CompletableFuture.supplyAsync(()->
        {
           try
           {
            Thread.sleep(5000);
           }
           catch(InterruptedException e)
           {

           }
           return "Hello World"; 
        });
        
        future.thenAccept(res->System.out.println(res));
        
        System.out.println("This Ran First");
        future.join();
    }
}
