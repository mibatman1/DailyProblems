package design;

import java.util.PriorityQueue;

public class LFUCache 
{
    private PriorityQueue<Pair>pq;
    public LFUCache(int capacity) {
        pq=new PriorityQueue<>((a,b)->a.freq-b.freq);
        pq.
    }
    
    public int get(int key) {
        
    }
    
    public void put(int key, int value) {
        
    }

    class Pair
    {
        int key, freq;
        Pair(int key, int frq)
        {
            this.key=key;
            this.freq=frq;
        }
    }
}
