
class Solution
{
    static class Pair{
        Node first;
        Node end;
        Pair(Node f,Node e){
            first=f;
            end=e;
        }
    }
    public static Node reverse(Node node, int k)
    {
        if(node==null || node.next==null || k==1)return node;
        //Your code here
        Node temp=node;
        ArrayList<Pair> arr= new ArrayList<>();
        while(temp!=null){
            Node start=temp;
            for(int i=0;i<k-1;i++){
                if(temp==null)break;
                temp=temp.next;
            }
            if(temp!= null){
                Node temp2=temp.next;
                temp.next=null;
                temp=temp2;
            }
            arr.add(reverseList(start));
        }
        node=arr.get(0).first;
        temp=arr.get(0).end;
        for(int i=1;i<arr.size();i++){
            temp.next=arr.get(i).first;
            temp=arr.get(i).end;
        }
        return node;
    }
    static Pair reverseList(Node head)
    {
        // code here
        if(head==null || head.next==null)return new Pair(head,head);
        Node prev=null;
        Node curr=head;
        Node next1=head.next;
        while(next1!=null){
            curr.next=prev;
            prev=curr;
            curr=next1;
            next1=next1.next;
        }
        curr.next=prev;
        return new Pair(curr,head);
    }
}
