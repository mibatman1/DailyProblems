package dailyproblems.arrays;

import java.util.Arrays;

// https://leetcode.com/problems/defuse-the-bomb/description/?envType=problem-list-v2&envId=array&difficulty=EASY
public class DefuseTheBomb 
{
    public int[] decrypt(int[] code, int k) 
    {
        if(k==0)
        {
            Arrays.fill(code, 0);
        }
        if(k>0)
        {
            for(int i=0;i<code.length;i++)
            {
                for(int j=i;j<k;j++)
                {
                    code[i]+=code[j%k];
                }
            }
        }
        return code;
    }

    public static void main(String[] args) 
    {
        int arr[]={1,2,3,4};
        DefuseTheBomb defuseTheBomb=new DefuseTheBomb();
        int a[]=defuseTheBomb.decrypt(arr, 2);
        for(var s:a)
        {
            System.out.println(s);
        }       
    }
}
