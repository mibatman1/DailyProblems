package dailyproblems.stacksqueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class NextGreaterElement 
{
    public int[] nextGreaterElement(int[] nums1, int[] nums2) 
    {
        int res[]=new int[nums1.length];
        Map<Integer, Integer>map=new HashMap<>();
        Deque<Integer>st=new ArrayDeque<>();
        for(int i=0;i<nums1.length;i++)
        {
            map.put(nums1[i], i);
        }
        for(int i=nums2.length-1;i>=0;i--)
        {
            while(!st.isEmpty() && nums2[i]>st.peek()) 
            {
                st.pop();
            }
            if(map.containsKey(nums2[i]))
            {
                if(st.isEmpty())
                {
                    res[map.get(nums2[i])]=-1;
                }
                else
                {
                    res[map.get(nums2[i])]=st.peek();
                }
            }
            st.push(nums2[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[]={4,1,2};
        int arr2[]={1,3,4,2};
        NextGreaterElement s=new NextGreaterElement();
        int a[]=s.nextGreaterElement(arr, arr2);
        for(int i=0;i<a.length;i++)
        {
            System.out.println(a[i]);
        }
    }



    // int[] result = new int[nums1.length];
    //     Stack<Integer> stack = new Stack<>();
    //     HashMap<Integer, Integer> store = new HashMap<>();
    //     for(int i =0; i<nums1.length; i++){
    //         store.put(nums1[i], i);
    //     }

    //     for(int i =nums2.length-1; i>=0; i--){
    //         while(!stack.isEmpty() && nums2[i] > stack.peek()){
    //             stack.pop();
    //         }
    //         if(store.containsKey(nums2[i])){
    //             if(stack.isEmpty()){
    //                 result[store.get(nums2[i])] = -1;
    //             }
    //             else{
    //                 result[store.get(nums2[i])] = stack.peek();
    //             }
    //         }
    //         stack.push(nums2[i]);
    //     }
    //     return result;
}
