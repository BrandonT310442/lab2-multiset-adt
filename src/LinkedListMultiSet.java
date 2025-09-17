
// Node is only used inside the LinkedList class, so we define it in the same file;
// there can only be one public class in a file, but there can also be non-public classes.
class Node {
    int item;
    Node next;
    Node(int item) {
        this.item = item;
    }
}


public class LinkedListMultiSet extends MultiSet {

    // a linked list initially is empty
    private Node front;
    private int size;


    public void add(int item) {
        Node newNode =  new Node(item);
        newNode.next = front;
        front = newNode;
        size += 1;
    }

    public void remove(int item) {
        Node curr = front;
        Node prev = null;
        while (curr != null) {
            if (curr.item == item) {
                size -=1;
                if (prev != null) {
                    prev.next = curr.next;
                }
                else{
                    front.next = curr.next;
                }
                return;
            }
            Node temp = curr;
            curr = curr.next;
            prev = temp;
        }
    }

    public boolean contains(int item) {
        Node curr = front;
        while (curr!=null){
            if (curr.item == item){
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    public boolean isEmpty() {
        Node curr = front;
        if (curr == null){
            return true;
        }
        return false;
    }


    public int count(int item) {
        Node curr = front;
        int num_seen = 0;
        while (curr!=null) {
            if (curr.item == item) {
                num_seen += 1;
            }
            curr = curr.next;
        }
        return num_seen;
    }

    public int size() {
        Node curr = front;
        int count = 0;
        while (curr!=null){
            count++;
            curr = curr.next;
        }
        return count;
    }
}
