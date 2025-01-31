import java.util.Stack;

public class HW1 {

    static class LinkedList {
        static class Node {
            int data;
            Node next;

            Node(int d) {
                data = d;
                next = null;
            }
        }

        Node head;

        /*
         * Method sortedInsert() - this method will insert a new node to the
         * linked list containing the value specified in the parameter 'data'.
         * The newly inserted node will be inserted in sorted order within
         * the linked-list.
         */
        public void sortedInsert(int data) {
            Node newNode = new Node(data);
            if (head == null || head.data >= data) {
                newNode.next = head;
                head = newNode;
                return;
            }
            Node current = head;
            while (current.next != null && current.next.data < data) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }

        /*
         * Method removeElementsLT() - this method removes all nodes that contain a
         * value that is less than the provided parameter 'ltValue'.
         */
        public void removeElementsLT(int ltValue) {
            while (head != null && head.data < ltValue) {
                head = head.next;
            }
            Node current = head;
            while (current != null && current.next != null) {
                if (current.next.data < ltValue) {
                    current.next = current.next.next;
                } else {
                    current = current.next;
                }
            }
        }

        /*
         * Method removeElement() - this method removes all nodes that contain a
         * value equal to the value provided in the parameter 'value'.
         */
        public void removeElement(int value) {
            while (head != null && head.data == value) {
                head = head.next;
            }
            Node current = head;
            while (current != null && current.next != null) {
                if (current.next.data == value) {
                    current.next = current.next.next;
                } else {
                    current = current.next;
                }
            }
        }
    }

    static class Stacks {
        /*
         * Method isPalindrome() - This method will return the boolean value 'true'
         * or 'false' on if the passed-in parameter string is a palindrome or not.
         *
         * The routine should be case insensitive! Meaning 'RaCe cAr' is a palindrome.
         * Moreover, spaces are ignored, so both 'race car' and 'racecar' are palindromes.
         *
         * The method should utilize the provided Stack class.
         */
        public static boolean isPalindrome(String input) {
            Stack<Character> stack = new Stack<>();
            input = input.toLowerCase().replaceAll("\\s+", "");
            for (char c : input.toCharArray()) {
                stack.push(c);
            }
            for (char c : input.toCharArray()) {
                if (stack.pop() != c) {
                    return false;
                }
            }
            return true;
        }

        /*
         * Method findLargestK() - This method will return the largest index
         * position in the stack for the value specified by the parameter 'k'.
         */
        public static int findLargestK(Stack<Integer> stack, int k) {
            Stack<Integer> tempStack = new Stack<>();
            int index = -1, position = 0;
            while (!stack.isEmpty()) {
                int val = stack.pop();
                tempStack.push(val);
                if (val == k) {
                    index = position;
                }
                position++;
            }
            while (!tempStack.isEmpty()) {
                stack.push(tempStack.pop());
            }
            return index;
        }
    }

    /*******************************
     * Algorithm Analysis
     * Below are two methods, algorithmAnalysis1 and algorithmAnalysis2.
     * Modify the return statement to return the correct option number.
     *********************************/

    public static int algorithmAnalysis1(int n, int m) {
        int a = 0, b = 0;
        for (int i = 0; i < n; i++)
            a += Math.random();
        for (int j = 0; j < m; j++)
            b += Math.random();
        /*
         * Select the correct option listed below:
         *   1. O(N * M) time, O(1) space
         *   2. O(N + M) time, O(N + M) space
         *   3. O(N + M) time, O(1) space
         *   4. O(N * M) time, O(N + M) space
         */
        return 3; // O(N + M) time, O(1) space
    }

    public static int algorithmAnalysis2(int n) {
        int i, j, k = 0;
        for (i = n / 2; i <= n; i++)
            for (j = 2; j <= n; j = j * 2)
                k += n / 2;
        /*
         * Select the correct option listed below:
         *   1. O(N) time
         *   2. O(N log N) time
         *   3. O(N^2) time
         *   4. O(N^2Log n) time
         */
        return 2; // O(N log N) time
    }
}
