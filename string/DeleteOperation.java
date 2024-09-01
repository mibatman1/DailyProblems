package string;

public class DeleteOperation 
{
    public int minDistance(String word1, String word2) 
    {
        int i=0,j=0;
        if(word1.contains(word2))
        {
            int a=word1.indexOf(word2);
            while(a<word1.length() && i<word2.length())
            {
                if(word2.charAt(i)!=word1.charAt(a))
                {
                    break;
                }
                i++;
                a++;
            }
        }
        if(word2.contains(word1))
        {
            int a=word2.indexOf(word1);
            while(a<word2.length() && i<word1.length())
            {
                if(word1.charAt(j)!=word2.charAt(a))
                {
                    break;
                }
                j++;
                a++;
            }
        }
        return Math.abs(word1.length()-i)+Math.abs(word2.length()-j);
        
    }
    public static void main(String[] args) {
        DeleteOperation deleteOperation=new DeleteOperation();
        System.out.println(deleteOperation.minDistance("sea", "eat"));
        
    }
}
