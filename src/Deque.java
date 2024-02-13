import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private class Node{
        Item data;
        Node next;
        Node prev;
        public Node(Item data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }

    }

    private Node first;
    private Node last;
    private int size;

    // construct an empty deque
    public Deque(){
        first = null;
        last = null;
        size = 0;
    }

    // is the deque empty?
    public boolean isEmpty(){
        return size == 0;
    }

    // return the number of items on the deque
    public int size(){
        return size;
    }

    // add the item to the front
    public void addFirst(Item item){
        if(item == null){
            throw new IllegalArgumentException();
        }

        if(first == null){
            first = new Node(item);
            last = first;
        }
        else{
            Node old_first = first;
            first = new Node(item);
            first.next = old_first;
            old_first.prev = first;
        }
        size++;
    }

    // add the item to the back
    public void addLast(Item item){
        if(item == null){
            throw new IllegalArgumentException();
        }

        if(last == null){
            last = new Node(item);
            first = last;
        }
        else{
            Node old_last = last;
            last = new Node(item);
            old_last.next = last;
            last.prev = old_last;
        }
        size++;
    }


    // remove and return the item from the front
    public Item removeFirst(){
        if(first == null){
            throw new NoSuchElementException();
        }
        else{
            Node old_first = first;
            first = first.next;
            if(first != null){
                first.prev = null;
            }
            else{
                last = first;
            }
            size--;
            return old_first.data;
        }

        }

    // remove and return the item from the back
    public Item removeLast(){
        if(last == null){
            throw new NoSuchElementException();
        }
        else{
            Node old_last = last;
            last = last.prev;
            if(last != null){
                last.next = null;
            }
            else{
                first = last;
            }

            size--;
            return old_last.data;
        }
        }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator(){
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item>{
        private Node current;
        public DequeIterator(){
            current = first;
        }
        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            Item item = current.data;
            current = current.next;
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
    // unit testing (required)
    public static void main(String[] args){
        Deque<Integer> deque = new Deque<>();
        deque.addFirst(4);
//        deque.addLast(2);
//        deque.addFirst(1);
//        deque.addLast(5);
//        StdOut.println(deque.removeFirst());
//        StdOut.println(deque.removeLast());
//        StdOut.println(deque.isEmpty());
        Iterator<Integer> i = deque.iterator();
//        StdOut.println(i.next());
    }

}
