package ru.Vsuet.mtx;

import java.util.function.Predicate;

public interface IList {

    /**
     * adds value into list tail
     * */
    void add(int value);

    /**
     * adds value into list by index
     * @param idx
     * @param value
     */
    void add(int idx, int value);

    /**
     * removes element by index
     * @param idx
     */
    void remove(int idx);

    /**
     * removes element by condition
     * @param predicate
     */
    void remove(Predicate<Integer> predicate);

    /**
     * returns element by index
     * @param idx
     * @return
     */
    int get(int idx);
    int size ();

    class ILinkedList implements IList {
        private Node head;
        private int size;

        private class Node {
            int value;
            Node next;

            Node(int value) {
                this.value = value;
                this.next = null;
            }
        }

        @Override
        public void add(int value) {
            Node newNode = new Node(value);
            if (head == null) {
                head = newNode;
            } else {
                Node currentNode = head;
                while (currentNode.next != null) {
                    currentNode = currentNode.next;
                }
                currentNode.next = newNode;
            }
            size++;
        }

        @Override
        public void add(int idx, int value) {
            if (idx < 0 || idx > size) {
                throw new IndexOutOfBoundsException("Элемент не найден:");
            }
            Node newNode = new Node(value);
            if (idx == 0) {
                newNode.next = head;
                head = newNode;
            } else {
                Node beforeNode = head;
                for (int i = 0; i < idx; i++) {
                    beforeNode = beforeNode.next;
                }
                newNode.next = beforeNode.next;
                beforeNode.next = newNode;
            }
            size++;
        }

        @Override
        public void remove(int idx) {
            if (idx < 0 || idx >= size) {
                throw new IndexOutOfBoundsException("Элемент не найден:");
            }
            if (idx == 0) {
                head = head.next;
            } else {
                Node beforeNode = head;
                for (int i = 0; i < idx - 1; i++) {
                    beforeNode = beforeNode.next;
                }
                beforeNode.next = beforeNode.next.next;
            }
            size--;
        }

        @Override
        public void remove(Predicate<Integer> predicate) {
            Node currentNode = head;
            Node prevNode = null;

            while (currentNode != null) {
                if (predicate.test(currentNode.value)) {
                    if (prevNode != null) {
                        prevNode.next = currentNode.next;
                    } else {
                        head = currentNode.next;
                    }
                    size--;
                } else {
                    prevNode = currentNode;
                }
                currentNode = currentNode.next;
            }
        }

        @Override
        public int get(int idx) {
            if (idx < 0 || idx >= size) {
                throw new IndexOutOfBoundsException("Элемент не найден:");
            }
            Node currentNode = head;
            for (int i = 0; i < idx; i++) {
                currentNode = currentNode.next;
            }
            return currentNode.value;
        }

        @Override
        public int size() {
            return size();
        }

    }

    class Main {
        public static void main(String[] args) {

            IList linkedList = new ILinkedList();
            linkedList.add(1);
            linkedList.add(2);
            linkedList.add(3);
            linkedList.add(4);
            System.out.println(linkedList.get(0));
            linkedList.remove(1);
            System.out.println(linkedList.get(1));
            System.out.println(linkedList.get(2));

            System.out.println(linkedList);
        }

    }
}