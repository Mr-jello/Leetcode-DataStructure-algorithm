package top.mrjello.data_structure;

import java.util.Random;

/**
 * @Author: jason@mrjello.top
 * @date: 2023/9/6 10:25
 * @Description: The bag class
 */
public class Bag<T> {
    // The first node
    private Node<T> head;
    // The number of elements in the bag
    private int n;
    // Random for grab() method
    private final Random random = new Random();

    /**
     * The Node class
     */
    private static class Node<T> {
        private T item;
        private Node<T> next;

        public Node(T item, Node<T> next) {
            this.item = item;
            this.next = next;
        }
    }

    /**
     * add(T Item) - To add an element to the bag
     * @param item T
     */
    public void add(T item) {
        Node<T> oldHead = head;
        head = new Node<>(item, oldHead);
        n++;
    }

    /**
     * clear ()- To clear ALL contents of the bag
     */
    public void clear() {
        head = null;
        n = 0;
    }

    /**
     * contains(T item) Returns true if the element is in the bag, false if it is not
     * @param item T
     * @return boolean
     */
    public boolean contains(T item) {
        Node<T> current = head;
        while (current != null) {
            // item is null
            if (item == null) {
                if (current.item == null) {
                    return true;
                }
            } else {
                // item is not null
                if (item.equals(current.item)) {
                    return true;
                }
            }
            current = current.next;
        }
        return false;
    }

    /**
     * grab() - Return a random element in the bag
     * @return T
     */
    public T grab() {
        if (head == null || n == 0) {
            return null;
        }
        // random index
        int index = random.nextInt(n);
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.item;
    }

    /**
     * isEmpty() - Returns true if the bag is empty, otherwise false
     * @return boolean
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * remove(T item) - Removes ONE instance of the item T. If the item exists and is removed then it returns true,else if it is not then it returns false
     * @return boolean
     */
    public boolean remove(T item) {
        if (head == null || n == 0) {
            return false;
        }
        // If the item is the first element
        if ((item == null && head.item == null) || (item != null && item.equals(head.item))) {
            head = head.next;
            n--;
            return true;
        }

        // If the item is not the first element
        Node<T> current = head;
        while (current.next != null) {
            if ((item == null && current.next.item == null) || (item != null && item.equals(current.next.item))) {
                current.next = current.next.next;
                n--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
     * size() - Returns the number of elements in the bag
     * @return int
     */
    public int size() {
        return n;
    }

    /**
     * toArray() - Returns an array with all of the elements in the bag in the array
     * @return ArrayList<T>
     */
    @SuppressWarnings("unchecked")
    public T[] toArray() {
        // if the bag is empty, return an empty array
        if (head == null || n == 0) {
            return (T[]) new Object[0];
        }

        // if the bag is not empty
        T[] array = (T[]) new Object[n];
        Node<T> current = head;

        for (int i = 0; i < n; i++) {
            array[i] = current.item;
            current = current.next;
        }

        return array;
    }

    /**
     * toString() - Returns a string that displays all the elements in the bag
     * @return String
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> current = head;
        while (current != null) {
            if (!sb.isEmpty()) {
                sb.append(", ");
            }
            sb.append(current.item);
            current = current.next;
        }
        return sb.toString();
    }

}
