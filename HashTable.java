public class HashTable {
    private static final int SIZE = 20;
    private final Node[] table;
    private int index(int key){
        int index = hash(key) % SIZE;
        return index;
    }
    public HashTable() {
        table = new Node[SIZE];
        for (int i = 0; i < SIZE; i++) {
            table[i] = null;
        }
    }

    public void put(int key, int value) {
        int index = index(key);
        Node newNode = new Node(key, value);
        if (table[index] == null) {
            table[index] = newNode;
        } else {
            Node current = table[index];
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public int get(int key) throws Exception {
        int index = index(key);
        Node curr = table[index];
        while (curr != null) {
            if (curr.key == key) {
                return curr.value;
            }
            curr = curr.next;
        }
        throw new Exception("Элемент не найден.");
    }

    public void remove(int key) throws Exception {
        int index = index(key);
        if (table[index] == null) {
            throw new Exception("Элемент не найден.");
        } else if (table[index].key == key) {
            table[index] = table[index].next;
        } else {
            Node prev = table[index];
            Node curr = table[index].next;
            while (curr != null) {
                if (curr.key == key) {
                    prev.next = curr.next;
                    return;
                }
                prev = curr;
                curr = curr.next;
            }
            throw new Exception("Элемент не найден.");
        }
    }

    private int hash(int key) {
        return Integer.hashCode(key);
    }

    private static class Node {
        private int key;
        private int value;
        private Node next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public int size(){
        int count = 0;
        for (int i = 0; i < SIZE; i++) {
            Node current = table[i];
            while (current != null) {
                count++;
                current = current.next;
            }
        }
        return count;
    }
}
