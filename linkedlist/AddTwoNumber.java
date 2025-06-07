package dailyproblems.linkedlist;

public class AddTwoNumber 
{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) 
    {
        var node=new ListNode(-1);
        var temp=node;
        int c=0;
        while(l1!=null || l2!=null || c!=0)
        {
            int sum=0;
            if(l1!=null)
            {
                sum+=l1.val;
                l1=l1.next;
            }
            if(l2!=null)
            {
                sum+=l2.val;
                l2=l2.next;
            }
            sum+=c;
            c=sum/10;
            var nextNode=new ListNode(sum%10);
            temp.next=nextNode;
            temp=nextNode;
        }
        return node.next;    
    }
    
    public static void main(String[] args) {
        System.out.println(10/10);
    }
}
