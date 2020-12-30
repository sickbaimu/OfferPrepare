package tools;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
    public static ListNode input(String s){

        ListNode node = new ListNode(Integer.parseInt(s.split("->")[0]));
        ListNode head = node;
        for(int i=1;i<s.split("->").length;i++){
            if(s.split("->")[i].equals("NULL")){
                return head;
            }else{
                node.next = new ListNode(Integer.parseInt(s.split("->")[i]));
                node = node.next;
            }
        }
        return head;
    }
    public static void output(ListNode node){
        while(node!=null){
            System.out.print(node.val+"->");
            node = node.next;
        }
        System.out.println("NULL");
    }
}
