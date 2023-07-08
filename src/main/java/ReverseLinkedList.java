public class ReverseLinkedList {
    public static void main(String[] args) {
        Node head = new Node(1);
        add(head, 2, 3, 4, 5, 6, 7);
        print("Linked list", head);
        reverseBetween(head, 3, 5);
        print("Reversed list between 3 and 5", head);
    }

    public static void reverseBetween(Node head, int left, int right) {
//    Separate list into three sub-lists: first part, reversed one, last part
//        Save positions for start of list (head), end of first part, start of sublist, end of sublist, start of second
        Node startOfFirstPart = null;
        Node endOfFirstPart = null;
        Node startOfSublist = null;
        Node endOfSublist = null;
        Node startOfSecondPart = null;
        Node endOfSecondPart = null;

//        If left = right then we don't reverse anything
        if (left == right) {
            return;
        }

        if (left == 1) {
            startOfFirstPart = head;
            endOfFirstPart = head;

            startOfSublist = head;
        }

        Node current = head;
        int currentIndex = 1;
        while (current.next != null) {
            if (startOfSublist == null && currentIndex == left - 1) {
                endOfFirstPart = current;
                startOfSublist = current.next;
            }

            if (currentIndex == right) {
                endOfSublist = current;
                startOfSecondPart = current.next;
            }

            current = current.next;
            currentIndex++;
        }

        endOfSecondPart = current;

        if (right == currentIndex) {
            endOfSublist = current;
            startOfSecondPart = current;
        }

//        reverse middle part here
        Node previous = null;
        Node next = null;
        current = startOfSublist;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        endOfFirstPart.next = startOfSublist;
        endOfSublist.next = startOfSecondPart;
    }


    public static Node reverseRecursive(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node res = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return res;
    }

    public static Node reverse(Node head) {
        Node currentNode = head;
        Node previousNode = null;
        Node nextNode = null;

        while (currentNode != null) {
            nextNode = currentNode.next; // Save the link to the next node
            currentNode.next = previousNode; // Connect the current node to the previous one
            previousNode = currentNode; // Set the previous node as the current node for the next iteration
            currentNode = nextNode; // Move over to the next node that we saved
        }

        head = previousNode; // CurrentNode will point to null, so the new head is the end of the list and the links
        // are reversed
        return head;
    }


    public static void add(Node head, int... args) {
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        for (int num : args) {
            current.next = new Node(num);
            current = current.next;
        }
    }

    public static void print(String message, Node head) {
        System.out.print(message + ": ");
        Node current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static class Node {
        Node next;
        int val;

        public Node(int val) {
            this.val = val;
            next = null;
        }
    }
}
