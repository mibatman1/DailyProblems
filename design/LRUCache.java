package design;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/lru-cache/?envType=problem-list-v2&envId=mbnk3qwv
public class LRUCache 
{
    private Queue<Pair>q;
    int arr[];
    public LRUCache(int capacity) {
        q=new LinkedList<>();
        arr=new int[capacity];
        Arrays.fill(arr, -1);
    }
    
    public int get(int key) {
        
    }
    
    public void put(int key, int value) {
        if(arr[key-1]!=-1)
        {
            
        }
    }
}

class Pair
{
    int key, pair;
    public Pair(int key, int pair)
    {
        this.key=key;
        this.pair=pair;
    }
}
