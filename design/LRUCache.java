package design;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

// https://leetcode.com/problems/lru-cache/?envType=problem-list-v2&envId=mbnk3qwv
public class LRUCache 
{
    private Deque<Integer>lru;
    private Map<Integer, Integer>mp;
    int capacity;
    public LRUCache(int capacity) {
        lru=new LinkedList<>();
        mp=new HashMap<>();
        this.capacity=capacity;
    }
    
    public int get(int key) {
        if(!mp.containsKey(key))
            return -1;
        lru.remove(key);
        lru.addLast(key);
        return mp.get(key);
    }
    
    public void put(int key, int value) {
        if(mp.containsKey(key))
        {
            mp.remove(key);
            lru.remove(key);
        }
        mp.put(key, value);
        lru.addLast(key);
        if(lru.size()>this.capacity)
        {
            var node=lru.pollFirst();
            mp.remove(node);
        }
    }
}
