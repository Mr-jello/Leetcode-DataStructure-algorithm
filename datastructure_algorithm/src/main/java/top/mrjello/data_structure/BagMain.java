package top.mrjello.data_structure;

import java.util.Arrays;

/**
 * @Author: jason@mrjello.top
 * @date: 2023/9/6 12:13
 * @Description: The main class of the bag
 */
public class BagMain {
    public static void main(String[] args) {
        Bag<Object> bag = new Bag<>();

        // add() method
        bag.add(1);
        bag.add("hello");
        bag.add(null);
        bag.add(3.14);
        bag.add(true);

        // contains() method
        System.out.println("bag contains 3: " + bag.contains(3));

        // isEmpty() method
        System.out.println("bag isEmpty: " + bag.isEmpty());

        // size() method
        System.out.println("bag size: " + bag.size());

        // grab() method
        System.out.println("bag grab: " + bag.grab());

        // remove() method
        System.out.println("bag remove: " + bag.remove(null));

        // toString() method
        System.out.println("bag toString: " + bag.toString());

        // toArray() method
        System.out.println("bag toArray: " + Arrays.toString(bag.toArray()));

        // clear() method
        bag.clear();
        System.out.println("after bag clear, bag size: " + bag.size());
    }
}
