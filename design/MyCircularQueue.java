package design;

public class MyCircularQueue 
{
    private int cirQueue[];
    private int size, capacity, front;

    public MyCircularQueue(int k) {
        cirQueue=new int[k];
        this.size=0;
        this.capacity=k;
        this.front=0; 
    }

    public boolean enQueue(int value) {
        if(size==capacity)
            return false;
        var rear=(front+size)%capacity;
        cirQueue[rear]=value;
        size++;
        return true;
    }
    
    public boolean deQueue() {
        if(size==0)
            return false;
        front=(front+1)%capacity;
        size--;
        return true;
    }
    
    public int Front() {
        if(size==0)
            return -1;
        return cirQueue[front];
    }
    
    public int Rear() {
        if(size==0)
            return -1;
        return cirQueue[(front+size-1)%capacity];

    }
    
    public boolean isEmpty() {
        return size==0;
    }
    
    public boolean isFull() {
        return size==capacity;
    }

    public static void main(String[] args) {
        MyCircularQueue myCircularQueue=new MyCircularQueue(3);
        System.out.println(myCircularQueue.enQueue(1));
        System.out.println(myCircularQueue.enQueue(2));
        System.out.println(myCircularQueue.enQueue(3));
        System.out.println(myCircularQueue.enQueue(4));
        System.out.println(myCircularQueue.Rear());
        System.out.println(myCircularQueue.isFull());
        System.out.println(myCircularQueue.deQueue());
        System.out.println(myCircularQueue.enQueue(4));
        System.out.println(myCircularQueue.Rear());
    }
}

// https://v0.dev/chat/fork-of-supreme-seeds-6ZLxtRQW7AE?p=0&f=0