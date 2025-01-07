package potd;

public class ShiftingLetterII 
{
    // public String shiftingLetters(String s, int[][] shifts) {
    //     StringBuilder str=new StringBuilder(s);
    //     for(var it:shifts)
    //     {
    //         int start=it[0];
    //         int end=it[1];
    //         int check=it[2];
    //         for(int i=start;i<=end;i++)
    //         {
    //             if(check==1)
    //             {
    //                 if(str.charAt(i)=='z')
    //                 {
    //                     str.setCharAt(i, 'a');
    //                 }
    //                 else
    //                 {
    //                     str.setCharAt(i, (char)(str.charAt(i)+1));
    //                 }
    //             }
    //             else if(check==0)
    //             {
    //                 if(str.charAt(i)=='a')
    //                 {
    //                     str.setCharAt(i, 'z');
    //                 }
    //                 else
    //                 {
    //                     str.setCharAt(i, (char)(str.charAt(i)-1));
    //                 }
    //             }
    //         }
    //     }
    //     return str.toString();
    // }

    public String shiftingLetters(String s, int[][] shifts) 
    {
        int diff[]=new int[s.length()+1];
        for(var it:shifts)
        {
            if(it[2]==1)
            {
                diff[it[0]]++;
                diff[it[1]+1]--;
            }
            else
            {
                diff[it[0]]--;
                diff[it[1]+1]++;
            }
        }
        for(var it:diff)
        {
            System.out.print(it);
        }
        for(int i=1;i<=s.length();i++)
        {
            diff[i]+=diff[i-1];
        }
        StringBuilder str=new StringBuilder();
        for(int i=0;i<s.length();i++)
        {
            int count=diff[i]%26;
            if(count<0)
                count+=26;
            char curr=(char)((s.charAt(i)-'a'+count)%26+97);
            str.append(curr);
        }
        return str.toString();
    }
    
    public static void main(String[] args) {
        String str="abc";
        int arr[][]={{0,1,0},{1,2,1},{0,2,1}};
        ShiftingLetterII shiftingLetterII=new ShiftingLetterII();
        System.out.println(shiftingLetterII.shiftingLetters(str, arr));
    }
}



