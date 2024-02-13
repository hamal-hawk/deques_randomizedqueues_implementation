import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Object[] queue;
    private int size;

    // construct an empty randomized queue
    public RandomizedQueue(){
        queue = (Item[]) new Object[1];
        size = 0;
    }

    private void expandArray(){
        int newSize = queue.length * 2;
        Object[] newQueue = (Item[]) new Object[newSize];
        for(int i = 0; i < queue.length; i++){
            newQueue[i] = queue[i];
        }
        queue = newQueue;
    }

    private void shrinkArray(){
        int newSize = queue.length / 2;
        Object[] newQueue = (Item[]) new Object[newSize];
        for(int i = 0; i < newQueue.length; i++){
            newQueue[i] = queue[i];
        }
        queue = newQueue;

    }

    // is the randomized queue empty?
    public boolean isEmpty(){
        return size() == 0;
    }

    // return the number of items on the randomized queue
    public int size(){
        return size;
    }

    // add the item
    public void enqueue(Item item){
        if(item == null){
            throw new IllegalArgumentException();
        }
        if(size >= queue.length){
            expandArray();
        }

        if(size == 0){
           queue[size++] = item;
        }
        else{
            int index = StdRandom.uniformInt(size);
            Item temp = (Item) queue[index];
            queue[index] = item;
            queue[size++] = temp;
        }
    }


    // remove and return a random item
    public Item dequeue(){
        if(size() == 0){
            throw new NoSuchElementException();
        }
        int removeIndex = StdRandom.uniformInt(size);
        Item removedItem = (Item) queue[removeIndex];
        queue[removeIndex] = queue[--size];
        queue[size] = null;

        if(size() < queue.length/4){
            shrinkArray();
        }

        return removedItem;
    }

    // return a random item (but do not remove it)
    public Item sample(){
        if(size() == 0){
            throw new NoSuchElementException();
        }

        return (Item) queue[StdRandom.uniformInt(size)];
    }



    private class QueueIterator implements Iterator<Item>{
        int randomIndices[];
        int index = 0;
        public QueueIterator(){
            randomIndices = new int[size];
            for(int i = 0; i < size; i++){
                randomIndices[i] = i;
            }
            StdRandom.shuffle(randomIndices);
        }

        public boolean hasNext() {
//            StdOut.println("Remaining elements: "+remainingElements);
            return index < size;
        }

        public Item next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            return (Item) queue[randomIndices[index++]];
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator(){
        return new QueueIterator();
    }

//    public void display(){
//        for(int i = 0; i< queue.length; i++){
//            StdOut.println("Index: "+i+" Element: "+queue[i]);
//        }
//    }

    // unit testing (required)
    public static void main(String[] args){
        RandomizedQueue<Integer> queue = new RandomizedQueue<>();

        queue.enqueue(1);
        queue.dequeue();
        queue.iterator();
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.isEmpty();

        queue.dequeue();
        queue.sample();

        Iterator<Integer> i = queue.iterator();
        i.hasNext();
        i.next();






    }

}
