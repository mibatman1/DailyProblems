package dailyproblems.twopointer;

import java.util.HashMap;
import java.util.Map;

public class FruitsIntoBasket {

    // 1,2,3,2,2
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer>mp=new HashMap<>();
        int r=0, l=0, len=0;
        while(r<fruits.length){
            mp.put(fruits[r], mp.getOrDefault(fruits[r], 0)+1);
            if(mp.size()>2){
                mp.put(fruits[l], mp.get(fruits[l])-1);
                if(mp.get(fruits[l])==0){
                    mp.remove(fruits[l]);
                }
                l++;
            }
            else if(mp.size()<=2){
                len=Math.max(len, r-l+1);
            }
            r++;
        }
        return len;
    }

    public static void main(String[] args) {
        FruitsIntoBasket fruitsIntoBasket=new FruitsIntoBasket();
        System.out.println(fruitsIntoBasket.totalFruit(new int[]{0,1,2,2}));
    }
}
