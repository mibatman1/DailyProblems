package dailyproblems.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

// https://leetcode.com/problems/design-a-number-container-system/?envType=daily-question&envId=2025-02-08
public class NumberContainers 
{
    private Map<Integer, Integer>mp;
    private Map<Integer, PriorityQueue<Integer>>pq;

    public NumberContainers() {
        mp=new HashMap<>();
        pq=new HashMap<>();
    }
    
    public void change(int index, int number) {
        mp.put(index,number);
        pq.computeIfAbsent(number, k->new PriorityQueue<>()).add(number);
    }
    
    public int find(int number) 
    {
        if(!pq.containsKey(number))
            return -1;
        var tempPQ=pq.get(number);
        while(!tempPQ.isEmpty())
        {
            var idx=tempPQ.peek();
            if(mp.get(idx)==number)
                return idx;
            tempPQ.poll();
        }
        return -1;
    }

    public static void main(String[] args) 
    {
        NumberContainers numberContainers=new NumberContainers();
        System.out.println(numberContainers.find(10));
        numberContainers.change(2, 10);
        //numberContainers.print();
    }
    
}
