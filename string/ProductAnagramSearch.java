package dailyproblems.string;
import java.util.*;

public class ProductAnagramSearch {
    public static List<List<String>> getProductMatches(String[] products, String[] queries) {
        List<List<String>> result = new ArrayList<>();
        
        
        for (String query : queries) {
            List<String> matches = new ArrayList<>();
            
            for (String product : products) {
                if (isAnagram(query, product)) {
                    matches.add(product);
                }
            }
            
            Collections.sort(matches);
            result.add(matches);
        }
        
        return result;
    }
    
    private static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        
        char[] str1 = s1.toLowerCase().toCharArray();
        char[] str2 = s2.toLowerCase().toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        
        return Arrays.equals(str1, str2);
    }
    
    public static void main(String[] args) {
        // Test cases
        String[] products1 = {"emits", "items", "baker","times", "break"};
        String[] queries1 = {"mites","brake"};
        
        List<List<String>> result1 = getProductMatches(products1, queries1);
        System.out.println("Test Case 1: " + result1);
        
        // Additional test cases
        // String[] products2 = {"cat", "dog", "tac"};
        // String[] queries2 = {""};
        // List<List<String>> result2 = getProductMatches(products2, queries2);
        // System.out.println("Test Case 2: " + result2);
        
        // String[] products3 = {"hello", "world"};
        // String[] queries3 = {"xyz"};
        // List<List<String>> result3 = getProductMatches(products3, queries3);
        // System.out.println("Test Case 3: " + result3);
    }
}
