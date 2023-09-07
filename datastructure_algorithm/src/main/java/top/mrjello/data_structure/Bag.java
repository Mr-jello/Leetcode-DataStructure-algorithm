package top.mrjello.data_structure;

import java.util.Iterator;

/**
 * @Author: jason@mrjello.top
 * @date: 2023/9/6 10:25
 * @Description: The bag class
 */
public class Bag<T> {
    private Node<T> head;
    private int n;


    /**
     * The Node class
     * @param <T>
     */
    private static class Node<T> {
        private T item;
        private Node<T> next;

        public Node() {}

        public Node(T item, Node<T> next) {
            this.item = item;
            this.next = next;
        }

        public T getItem() {
            return item;
        }

        public void setItem(T item) {
            this.item = item;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }

//    /**
//     * add(T Item) - To add an element to the bag
//     * @return void
//     */
//    public void add(T item) {
//        Node<T> oldFirst = first;
//        first = new Node<T>();
//        first.item = item;
//        first.next = oldFirst;
//        n++;
//    }
//
//    /**
//     * clear ()- To clear ALL contents of the bag
//     * @return void
//     */
//    public void clear() {
//        first = null;
//        n = 0;
//    }
//
//    /**
//     * contains(T item)  Returns true if the element is in the bag, false if it is not
//     * @return boolean
//     */
//    public boolean contains(T item) {
//        Node<T> current = first;
//        while (current != null) {
//            if (current.item.equals(item)) {
//                return true;
//            }
//            current = current.next;
//        }
//        return false;
//    }
//
//    /**
//     * grab() - Return a random element in the bag
//     * @return T
//     */
//    public T grab() {
//        if (first == null || n == 0) {
//            return null;
//        }
//        // random index
//        int index = (int) (Math.random() * n);
//        Node<T> current = first;
//        for (int i = 0; i < index; i++) {
//            current = current.next;
//        }
//        return current.item;
//    }
//
//    /**
//     * isEmpty() - Returns true if the bag is empty, otherwise false
//     * @return boolean
//     */
//    public boolean isEmpty() {
//        return first == null;
//    }
//
//    /**
//     * remove(T item) - Removes ONE instance of the item T.  If the item exists and is removed then it returns true, else if it is not then it returns false
//     * @return boolean
//     */
//    public boolean remove(T item) {
//        if (first == null || n == 0) {
//            return false;
//        }
//        if (first.item.equals(item)) {
//            first = first.next;
//            n--;
//            return true;
//        }
//        Node<T> current = first;
//        while (current.next != null) {
//            if (current.next.item.equals(item)) {
//                current.next = current.next.next;
//                n--;
//                return true;
//            }
//            current = current.next;
//        }
//        return false;
//    }
//
//    /**
//     * size() - Returns the number of elements in the bag
//     * @return int
//     */
//    public int size() {
//        return n;
//    }
//
//    /**
//     * toArray() - Returns an array with all of the elements in the bag in the array
//     * @return T[]
//     */
//    public T[] toArray() {
//        T[] arr = (T[]) new Object[n];
//        Node<T> current = first;
//        for (int i = 0; i < n; i++) {
//            arr[i] = current.item;
//            current = current.next;
//        }
//        return arr;
//    }
//
//    /**
//     * toString() - Returns a string that displays all the elements in the bag
//     * @return String
//     */
//    public String toString() {
//        return null;
//    }

}
