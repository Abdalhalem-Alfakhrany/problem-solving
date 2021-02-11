class ListNode {
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

    @Override
    public String toString() {
        return "" + this.val;
    }
}

public class App {
    public static ListNode middleNode(ListNode head) {
        int sizeOfList = 0;

        ListNode next = head.next;

        while (true) {
            sizeOfList++;
            if (next.next == null) {
                sizeOfList++;
                break;
            }
            next = next.next;
        }

        System.out.println((sizeOfList / 2) + 1);
        for (int i = 0; i < (sizeOfList / 2) + 1; i++) {
            next = head.next;
        }

        return next;
    }

    public static void main(String[] args) throws Exception {
        ListNode list = new ListNode(1,
                new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        System.out.println(middleNode(list));
    }
}
