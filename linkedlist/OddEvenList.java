package dailyproblems.linkedlist;

// https://leetcode.com/problems/odd-even-linked-list/?envType=problem-list-v2&envId=mmbq602t
public class OddEvenList 
{
    public ListNode oddEvenList(ListNode head) 
    {
        var odd=head;
        var even=odd.next;
        var evenHead=even;
        while(even!=null && even.next!=null)
        {
            odd.next=even.next;
            odd=even.next;
            even.next=odd.next;
            even=odd.next;
        }
        odd.next=evenHead;
        return head;
    }
}
