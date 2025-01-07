package potd;

import java.util.ArrayList;
import java.util.List;

public class StringMatchingInAnArray 
{
    public List<String> stringMatching(String[] words) {
        List<String>ans=new ArrayList<>();
        for(int i=0;i<words.length;i++)
        {
            for(int j=0;j<words.length;j++)
            {
                if(i!=j && words[i].contains(words[j]))
                {
                    ans.add(words[j]);
                    break;
                }
            }
        }   
        return ans;
    }

    public static void main(String[] args) {
        String arr[]={"mass","as","hero","superhero"};
        StringMatchingInAnArray stringMatchingInAnArray=new StringMatchingInAnArray();
        System.out.println(stringMatchingInAnArray.stringMatching(arr));
    }
}
