public class HashTable {
    private int size = 3;
    public int resize = 1;
    private Node[] table;

    HashTable() {
        table = new Node[size];
        for (int i = 0; i < size; i++) {
            table[i] = null;
        }
    }

    public int get() {
        return size;
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

    private void resize() {
        if (resize > size * 0.75) {
            size = size * 2;
            Node[] newTable = new Node[size];
            System.arraycopy(table, 0, newTable, 0, table.length);
            table = newTable;
        } else if (resize > 0 && resize < size * 0.3) {
            size = size / 2;
            Node[] newTable = new Node[size];
            System.arraycopy(table, 0, newTable, 0, table.length);
            table = newTable;
        }
    }

    public void put(int key, int value) {
        int idx = index(key);
        Node newNode = new Node(key, value);
        resize();
        if (table[idx] == null) {
            table[idx] = newNode;
            resize++;
        } else {
            Node current = table[idx];
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            resize++;
        }
    }

    public int index(int key) {
        return (key % size);
    }

    public int size() {
        int count = 0;
        for (int i = 0; i < size; i++) {
            Node current = table[i];
            while (current != null) {
                count++;
                current = current.next;
            }
        }
        return count;
    }

    public int get(int key) throws Exception {
        Node currentNode = table[index(key)];
        while (currentNode != null) {
            if (currentNode.key == key) {
                return currentNode.value;
            }
            currentNode = currentNode.next;
        }
        throw new Exception("Element not found");
    }

    public void remove(int key) throws Exception {
        resize();
        int idx = index(key);
        if (table[idx] == null) {
            throw new Exception("Element not found");
        } else if (table[idx].key == key) {
            table[idx] = table[idx].next;
            resize--;
        } else {
            resize--;
            Node previosNode = table[idx];
            Node currentNode = table[idx].next;
            while (currentNode != null) {
                if (currentNode.key == key) {
                    previosNode.next = currentNode.next;
                    return;
                }
                previosNode = currentNode;
                currentNode = currentNode.next;
            }
        }
    }
}
