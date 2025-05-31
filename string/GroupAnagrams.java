
package dailyproblems.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams 
{
    public List<List<String>> groupAnagrams(String[] strs) 
    {
        Map<String, List<String>>mp=new HashMap<>();
        for(String str:strs)
        {
            char ch[]=str.toCharArray();
            Arrays.sort(ch);
            String ana=new String(ch);
            if(!mp.containsKey(ana))
            {
                mp.put(ana, new ArrayList<>());
            }
            mp.get(ana).add(str);
        }
        System.out.println(mp.values());
        return new ArrayList<>(mp.values());
    }
    public static void main(String[] args) {
        GroupAnagrams groupAnagram=new GroupAnagrams();
        String ars[]={"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagram.groupAnagrams(ars));
        
    }
}
