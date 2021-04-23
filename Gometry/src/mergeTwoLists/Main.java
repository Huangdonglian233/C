package mergeTwoLists;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        ListNode l1 = new ListNode();
        ListNode l2=new ListNode();
        ListNode l3=new ListNode();
        Solution s=new Solution();
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入l1");
        while(scanner.hasNextInt()){
            l1.val= scanner.nextInt();
            l1=new ListNode();
        }
        System.out.println("请输入l2");
        while(scanner.hasNextInt()){
            l2.val= scanner.nextInt();
            l2=new ListNode();
        }
        l3=s.MergeTwoLists(l1,l2);
        while(l3!=null){
            System.out.println(l3.val);
            l3=l3.next;
        }
    }
}
