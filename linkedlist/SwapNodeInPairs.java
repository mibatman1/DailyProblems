package dailyproblems.linkedlist;

public class SwapNodeInPairs 
{
    public ListNode swapPairs(ListNode head) 
    {
        var node=head;
        int i=1;
        while(i<=100 && node!=null)
        {
            if(i%2!=0)
            {
                var temp=node.val;
                node.val=node.next.val;
                node.next.val=temp;
            }
            i++;
            node=node.next;
        }
        return node;
    }    
}
