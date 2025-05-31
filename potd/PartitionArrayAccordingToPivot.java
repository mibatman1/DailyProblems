package dailyproblems.potd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PartitionArrayAccordingToPivot 
{
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer>ls=new ArrayList<>();
        List<Integer>ls1=new ArrayList<>();
        List<Integer>ls2=new ArrayList<>();
        for(var it:nums)
        {
            if(it<pivot)
                ls.add(it);
            else if(it==pivot)
                ls1.add(it);
            else
                ls2.add(it);
        }
        ls.addAll(ls1);
        ls.addAll(ls2);
        int i=0;
        int arr[]=new int[ls.size()];
        for(var it:ls)
        {
            arr[i++]=it;
        }
        return arr;
    }

    // Approach 2
    public int[] pivotArray1(int[] nums, int pivot)
    {
        int less=0, equal=0;
        for(var it:nums)
        {
            if(it<pivot)
            {
                less++;
            }
            else if(it==pivot)
            {
                equal++;
            }
        }
        int less1=0;
        int equal1=less;
        int greater=less+equal;
        int arr[]=new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            int num=nums[i];
            if(num<pivot)
            {
                arr[less1++]=num;
            }
            else if(num==pivot)
                arr[equal1++]=num;
            else 
                arr[greater++]=num;
        }
        return arr;
    }


    public static void main(String[] args) {
        int arr[]={9,12,5,10,14,3,10};
        int piv=10;
        PartitionArrayAccordingToPivot partitionArrayAccordingToPivot=new PartitionArrayAccordingToPivot();
        partitionArrayAccordingToPivot.pivotArray(arr, piv);
    }
    
}
