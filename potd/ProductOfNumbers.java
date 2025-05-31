package dailyproblems.potd;

import java.util.ArrayList;
import java.util.List;

public class ProductOfNumbers 
{
    private List<Integer>ls;
    private int prod=1;

    public ProductOfNumbers() {
        ls=new ArrayList<>();    
    }
    
    public void add(int num) {
        if(num==0)
        {
            ls.clear();
            prod=1;
            return;
        }
        prod*=num;
        ls.add(prod);
    }
    
    public int getProduct(int k) {
        if(ls.size()<k)
            return -1;
        return ls.get(ls.size()-1)/ls.get(ls.size()-k-1);
    }

    public static void main(String[] args) 
    {
           ProductOfNumbers productOfNumbers=new ProductOfNumbers();
           productOfNumbers.add(3);
           productOfNumbers.add(0);
           productOfNumbers.add(2);
           productOfNumbers.add(5);
           productOfNumbers.add(4);
           System.out.println(productOfNumbers.getProduct(2));
    }
}
