public class Hash {
    private static final int SIZE = 20;  // размер таблицы
    private final Node[] table; // массив узлов таблицы
    // конструктор
    public Hash() {
        table = new Node[SIZE];
        for (int i = 0; i < SIZE; i++) {
            table[i] = null;
        }
    }
    // вставка элемента в таблицу
    public void put(int key, int value) {
        int index = key % SIZE;// вычисляем индекс ячейки таблицы
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
    // вычисляем индекс ячейки таблиц
    public int get(int key) throws Exception {
        int index = key % SIZE;// вычисляем индекс ячейки таблицы
        Node curr = table[index];
        while (curr != null) {
            if (curr.key == key) {
                return curr.value;
            }
            curr = curr.next;
        }
        throw new Exception("Элемент не найден.");
    }
    // удаление элемента из таблицы
    public void remove(int key) throws Exception {
        int index = key % SIZE;// вычисляем индекс ячейки таблицы
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
    // класс узла списка
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

    //добавляем метод для получения размера таблицы
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