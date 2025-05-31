package dailyproblems.design;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// https://leetcode.com/problems/insert-delete-getrandom-o1/?envType=problem-list-v2&envId=mbnk3qwv
public class RandomizedSet 
{
    private List<Integer>set;

    public RandomizedSet() {
        set=new ArrayList<>();   
    }
    
    public boolean insert(int val) {
        if(set.contains(Integer.valueOf(val)))
            return false;
        set.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(set.contains(val))
        {
            set.remove(Integer.valueOf(val));
            return true;
        }
        return false;
    }
    
    public int getRandom() {
        Random random=new Random();
        int rand=random.nextInt(set.size());
        return set.get(rand);
    }

    public static void main(String[] args) {
        RandomizedSet randomizedSet=new RandomizedSet();
        System.out.println(randomizedSet.insert(1));
        System.out.println(randomizedSet.remove(2));
        System.out.println(randomizedSet.insert(2));
        System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.remove(1));
        System.out.println(randomizedSet.insert(2));
        System.out.println(randomizedSet.getRandom());
    }
}
