package design;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MedianFinder 
{
    private List<Integer>ls;
    int n=0;
    public MedianFinder() {
        ls=new ArrayList<>();
    }
    
    public void addNum(int num) {
        int pos=Collections.binarySearch(ls, num);
        if(pos>=0)
        {
            ls.add(pos+1, num);
        }
        else
        {
            ls.add(Math.abs(pos-1),num);
        }
        n++;
    }
    
    public double findMedian() {
        if (n%2==1) 
        {
            return ls.get(n / 2);
        }
        return (ls.get((n / 2) - 1) + ls.get(n / 2)) / 2.0;
    }

    public static void main(String[] args) {
        MedianFinder medianFinder=new MedianFinder();
        medianFinder.addNum(6);
        medianFinder.addNum(10);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(2);
        medianFinder.addNum(6);
        medianFinder.addNum(5);
        medianFinder.addNum(0);
        medianFinder.addNum(6);
        //medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }
}
