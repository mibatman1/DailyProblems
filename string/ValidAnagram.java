package string;

import java.util.Arrays;

public class ValidAnagram 
{
    public boolean isAnagram(String s, String t) {
        char ch[]=s.toCharArray();
        char ck[]=t.toCharArray();
        Arrays.sort(ch);
        Arrays.sort(ck);
        return Arrays.equals(ch,ck);
    }

    public static void main(String[] args) 
    {
        ValidAnagram validAnagram=new ValidAnagram();
        System.out.println(validAnagram.isAnagram("anagram", "anagram"));
    }
}
