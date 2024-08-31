package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortCharByFreq 
{
    public String frequencySort(String s) 
    {
        StringBuffer str=new StringBuffer();
        Map<Character, Integer>mp=new HashMap<>();
        for(char ch:s.toCharArray())
        {
            mp.put(ch, mp.getOrDefault(ch, 0)+1);
        }
        System.out.println(mp);
        List<Character>sl=new ArrayList<>(mp.keySet());
        System.out.println(sl);
        Collections.sort(sl,(a,b)->mp.get(b)-mp.get(a));
        System.out.println(sl);
        return "hello";
    }

    public static void main(String[] args) 
    {
        SortCharByFreq sortCharByFreq=new SortCharByFreq();
        System.out.println(sortCharByFreq.frequencySort("cccaabb"));   
    }
}
