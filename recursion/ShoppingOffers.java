package dailyproblems.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingOffers {

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        Map<List<Integer>, Integer> dp = new HashMap<>();
        return helper(price, special, needs, dp);
    }

    public int helper(List<Integer> price, List<List<Integer>> special, List<Integer> needs, Map<List<Integer>, Integer> dp){
        
        if(dp.containsKey(needs))   return dp.get(needs);

        int cost = 0;
        for(int i = 0; i < needs.size(); i++){
            cost += needs.get(i)*price.get(i);
        }

        for(List<Integer> offer : special){
            List<Integer> need = new ArrayList<>();
            boolean isReady = true;
            for(int i = 0; i < offer.size()-1; i++){
                if(needs.get(i) - offer.get(i) >= 0){
                    need.add(needs.get(i) - offer.get(i));
                } else {
                    isReady = false;
                    break;
                }
            }
            if(!isReady) continue;
            cost = Math.min(cost, offer.get(offer.size()-1) + helper(price, special, need, dp));
        }

        dp.put(needs, cost);
        return cost;
    }

    public static void main(String[] args) {
        ShoppingOffers shoppingOffers=new ShoppingOffers();
        List<Integer>price=List.of(2,5);
        List<Integer>needs=List.of(3, 2);
        List<List<Integer>>special=List.of(List.of(3,0,5), List.of(1,2,10));
        System.out.println(shoppingOffers.shoppingOffers(price, special, needs));
    }
}
