package dailyproblems.design;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SmallestInfiniteSet 
{
    private int curr;
    private Set<Integer>s;
    public SmallestInfiniteSet() {
        curr=1;
        s=new HashSet<>();
    }
    
    public int popSmallest() {
        if(!s.isEmpty())
        {
            int min=Collections.min(s);
            s.remove(min);
            return min;
        }
        curr++;
        return curr-1;
    }
    
    public void addBack(int num) {
        if(curr>num)
            s.add(num);
    }

    public static void main(String[] args) {
        
    }
}
