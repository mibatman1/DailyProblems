package design;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/design-an-ordered-stream/?envType=problem-list-v2&envId=mbnk3qwv
public class OrderedStream 
{
    private String arr[];
    int ptr=0;
    public OrderedStream(int n) 
    {
        arr=new String[n];
    }
    
    public List<String> insert(int idKey, String value) 
    {
        List<String>ans=new ArrayList<>();
        arr[idKey-1]=value;
        while(ptr<arr.length && arr[ptr]!=null)
        {
            ans.add(arr[ptr++]);
        }
        return ans;
    }

    public static void main(String[] args) {
        OrderedStream orderedStream=new OrderedStream(5);
        System.out.println(orderedStream.insert(3, "cccc"));
        System.out.println(orderedStream.insert(1, "aaaa"));
        System.out.println(orderedStream.insert(2, "bbbb"));
        System.out.println(orderedStream.insert(5, "eeee"));
        System.out.println(orderedStream.insert(4, "dddd"));
    }
}
