package dailyproblems.linkedlist;

public class RemoveNthNode 
{
    public ListNode removeNthFromEnd(ListNode head, int n) {
        var node=new ListNode();
        node.next=head;
        var fast=node;
        var slow=node;
        for(var i=1;i<=n;i++)
        {
            fast=fast.next;
        }
        while(fast.next!=null)
        {
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return node.next;
    }    
}
