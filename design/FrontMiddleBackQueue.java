package dailyproblems.design;

import java.util.LinkedList;
import java.util.List;

public class FrontMiddleBackQueue 
{
    private List<Integer>queue;
    public FrontMiddleBackQueue() {
        queue=new LinkedList<>();
    }
    
    public void pushFront(int val) {
        queue.addFirst(val);
        System.out.println(queue);
    }
    
    public void pushMiddle(int val) {
        int s=(queue.size())/2;
        queue.add(s, val);
        System.out.println(queue);
    }
    
    public void pushBack(int val) {
        queue.addLast(val);
        System.out.println(queue);
    }
    
    public int popFront() {
        if(queue.size()<=0)
        {
            return -1;
        }
        return queue.removeFirst();
    }
    
    public int popMiddle() {
        if(queue.size()<0)
            return -1;
        int s=(queue.size()-1)/2;
        System.out.println("Hello"+s);
        return queue.remove(s);
    }
    
    public int popBack() {
        if(queue.size()<0)
            return -1;
        return queue.removeLast();
    }

    public static void main(String[] args) {
        FrontMiddleBackQueue frontMiddleBackQueue=new FrontMiddleBackQueue();
        frontMiddleBackQueue.pushFront(1);
        frontMiddleBackQueue.pushBack(2);
        frontMiddleBackQueue.pushMiddle(3);
        frontMiddleBackQueue.pushMiddle(4);
        System.out.println(frontMiddleBackQueue.popFront());
        System.out.println(frontMiddleBackQueue.popMiddle());
        System.out.println(frontMiddleBackQueue.popMiddle());
        System.out.println(frontMiddleBackQueue.popBack());
        System.out.println(frontMiddleBackQueue.popFront());
    } 
}
