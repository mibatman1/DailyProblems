package stacksqueue;

import java.util.ArrayDeque;
import java.util.Deque;

//https://leetcode.com/problems/next-greater-element-ii/description/
public class NextGreaterElement2 
{
    public int[] nextGreaterElements(int[] nums) 
    {
        int res[]=new int[nums.length];
        int len=nums.length;
        Deque<Integer>st=new ArrayDeque<>();
        for(int i=(2*len-1);i>=0;i--)
        {
            while(!st.isEmpty() && st.peek()<=nums[i%len])
            {
                st.pop();
            }
            if(i<len)
            {
                if(st.isEmpty())
                {
                    res[i%len]=-1;
                }
                else
                {
                    res[i%len]=st.peek();
                }
            }
            st.push(nums[i%len]);
        }
        return res;
    }

    public static void main(String[] args) 
    {
        int res[]={1,2,1};
        NextGreaterElement2 s=new NextGreaterElement2();
        int arr[]=s.nextGreaterElements(res);
        for(int i=0;i<arr.length;i++)
        {
            System.out.println(arr[i]);
        }
    }
}
