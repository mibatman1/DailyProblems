package recursion;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/find-unique-binary-string/?envType=problem-list-v2&envId=mk7dslmg
public class FindUniqueBinaryString 
{
    public String findDifferentBinaryString(String[] nums) {
        Set<String>set=new HashSet<>();
        int n=nums.length;
        for(var num:nums)
        {
            set.add(num);
        }
        System.out.println(set);
        return solve("",n, set);
    }

    String solve(String str, int n, Set<String>set)
    {
        if(str.length()==n)
        {
            if(!set.contains(str))
            {
                set.add(str);
                return str;
            }
        }
        String zero=solve(str+"0", n, set);
        if(!zero.isEmpty())
            return zero;
        return solve(str+"1", n, set);
    }

    public static void main(String[] args) {
        String arr[]={"111","011","001"};
        FindUniqueBinaryString findUniqueBinaryString=new FindUniqueBinaryString();
        System.out.println(findUniqueBinaryString.findDifferentBinaryString(arr));
    }
}
