package dailyproblems.linkedlist;

public class MergeTwoSortedList 
{
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) 
    {
        if(list2==null)
            return list1;
        if(list1==null)
            return list2;
        var listNode=new ListNode(-1);
        var temp=listNode;
        while(list1!=null && list2!=null) 
        {
            if(list1.val<list2.val)
            {
                temp.next=list1;
                temp=list1;
                list1=list1.next;
            }
            else
            {
                temp.next=list2;
                temp=list2;
                list2=list2.next;
            }
        }
        if(list1!=null)
        {
            temp.next=list1;
            temp=list1;
        }
        else if(list2!=null)
        {
            temp.next=list2;
            temp=list2;
        }
        return listNode.next;    
    } 
}
