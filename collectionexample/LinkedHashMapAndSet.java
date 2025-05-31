package dailyproblems.collectionexample;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class LinkedHashMapAndSet 
{
    public static void main(String[] args) {
        LinkedHashMap<Integer, Integer>ls=new LinkedHashMap<>();
        LinkedHashSet<Integer>ls1=new LinkedHashSet<>();
        ls1.add(100);
        ls1.add(2);
        ls1.add(3);
        ls.put(null, 1);
        ls.put(1, null);
        ls.put(1, 100);
        System.out.println(ls1);
        System.out.println(ls);
    }
    
}
