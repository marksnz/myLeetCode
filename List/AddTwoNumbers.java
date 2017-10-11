/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) 
    {
        if (null == l1 || null == l2)
            return null;
        
        int _val = getVal(l1) + getVal(l2);
        ListNode out = new ListNode(_val % 10);
        _val /= 10;
        ListNode curr = out;
        ListNode newNode = null;
        while (_val != 0)
        {
            newNode = new ListNode(_val % 10);
            curr.next = newNode;
            curr = newNode;
            _val /= 10;
        }
        return out;
    }
    
    private int getVal(ListNode ln)
    {
        StringBuilder sval = new StringBuilder(Integer.toString(ln.val));
        while(ln.next != null)
        {
            ln = ln.next;
            sval.append(Integer.toString(ln.val));
        }
        return Integer.parseInt(sval.reverse().toString());
    }
    
    private void printList(ListNode ln)
    {
        System.out.print("(");
        while(ln.next != null)
        {
            System.out.print(ln.val + "->");
            ln = ln.next;
        }
        System.out.print(ln.val + ")");
    }
    
    public static void main(String[] args) 
    {
        // TODO Auto-generated method stub
        AddTwoNumbers atn = new AddTwoNumbers();
        AddTwoNumbers.ListNode l1 = atn.new ListNode(2);
        l1.next = atn.new ListNode(4); 
        l1.next.next = atn.new ListNode(3); 
        l1.next.next.next = atn.new ListNode(3); 
        AddTwoNumbers.ListNode l2 = atn.new ListNode(5);
        l2.next = atn.new ListNode(6); 
        l2.next.next = atn.new ListNode(4); 
        
        AddTwoNumbers.ListNode out = atn.addTwoNumbers(l1, l2);
        atn.printList(l1);
        System.out.print(" + ");
        atn.printList(l2);
        System.out.print(" = ");
        atn.printList(out);
        System.out.println();
    }
    
    class ListNode 
    {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
