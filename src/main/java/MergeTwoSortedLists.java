public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode list1 = new ListNode();
        System.out.println(list1.val + " " + list1.next.val + " " + list1.next.next.val);

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode iterator = head;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                iterator.next = list1;
                list1 = list1.next;
            } else {
                iterator.next = list2;
                list2 = list2.next;
            }

            iterator = iterator.next;
        }

        if (list1 != null) {
            iterator.next = list1;
        } else if (list2 != null) {
            iterator.next = list2;
        }

        return head.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
