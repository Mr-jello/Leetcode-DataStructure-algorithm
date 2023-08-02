package top.mrjello.algorithm.d6_ForceRecursion;

import java.util.Stack;

/**
 * @author jason@mrjello.top
 * @date 2023/8/1 17:14
 */
public class ReverseStackUsingRecursive {

    /**
     * 不使用额外数据结构，只使用递归逆序一个栈
     * 流程图：递归逆序栈.png
     * @param stack 待逆序的栈
     */
    public static void reverseStackUsingRecursive(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        //递归获取栈底元素
        int i = getAndRemoveLastElement(stack);
        //递归反转栈
        reverseStackUsingRecursive(stack);
        //将栈底元素压入栈
        stack.push(i);
    }

    /**
     * 获取栈底元素
     * 流程图：递归获取栈底元素.png
     * @param stack 待获取栈底元素的栈
     * @return 栈底元素
     */
    public static int getAndRemoveLastElement(Stack<Integer> stack) {
        //每次递归弹出一个元素，直到栈为空，返回栈底的元素
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            //如果栈底不为空，递归获取，随后stack把弹出的元素放回，然后返回栈底的元素
            int last = getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }
    }

}
