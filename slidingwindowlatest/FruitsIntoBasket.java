package dailyproblems.slidingwindowlatest;

import java.util.HashMap;
import java.util.Map;

public class FruitsIntoBasket {

    public int totalFruit(int[] fruits) {
        Map<Integer, Integer>mp=new HashMap<>();
        int l=0, r=0, len=Integer.MIN_VALUE;
        while(r<fruits.length)
        {
            mp.put(fruits[r], mp.getOrDefault(fruits[r], 0)+1);
            if(mp.size()>2)
            {
                mp.put(fruits[l], mp.get(fruits[l])-1);
                if(mp.get(fruits[l])==0)
                    mp.remove(fruits[l]);
                l++;
            }
            if(mp.size()<=2)
            {
                len=Math.max(len, r-l+1);
            }
            r++;
        }
        return len;
    }


    public static void main(String[] args) {
        String s=new String();
        s.contains('a');
    }
    
}
