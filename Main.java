public class Main {
    public static void main(String[] args) throws Exception {
        HashTable hashtable = new HashTable();
        hashtable.put(1, 10);
        hashtable.put(2, 20);
        hashtable.put(3, 30);
        System.out.println("Size: " + hashtable.size());
        System.out.println(hashtable.get(3));
        hashtable.remove(2);
        System.out.println("Size: " + hashtable.size());
    }
}

