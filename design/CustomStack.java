package design;

// https://leetcode.com/problems/design-a-stack-with-increment-operation/?envType=problem-list-v2&envId=mbnk3qwv
public class CustomStack 
{
    private int stack[];
    private int pointer=-1;
    private int maxSize=0;

    public CustomStack(int maxSize) {
        stack=new int[maxSize];
        this.maxSize=maxSize;    
    }
    
    public void push(int x) {
        if(pointer>=maxSize-1)
            return;
        stack[++pointer]=x;
    }
    
    public int pop() {
        if(pointer<0)
            return 0;
        int poppedElement=stack[pointer--];
        return poppedElement;
    }
    
    public void increment(int k, int val) {
        if(pointer<k)
        {
            for(int i=0;i<stack.length;i++)
            {
                stack[i]+=val;
            }
        }
        else
        {
            for(int i=0;i<k;i++)
            {
                stack[i]+=val;
            }
        }
    }

    void display()
    {
        for(var it:stack)
            System.out.print(it+" ");
    }

    public static void main(String[] args) {
        CustomStack customStack=new CustomStack(3);
        customStack.push(1);
        customStack.push(2);
        System.out.println(customStack.pop());
        customStack.push(2);
        customStack.push(3);
        customStack.push(4);
        //customStack.display();
        customStack.increment(5, 100);
        customStack.increment(2, 100);
        customStack.pop();
        customStack.pop();
        customStack.pop();
        customStack.pop();
        customStack.display();
    }
}
