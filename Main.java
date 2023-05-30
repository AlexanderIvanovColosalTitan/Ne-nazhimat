public class Main {
    public static void main(String[] args) throws Exception {
        HashTable hash = new HashTable();
        hash.put(1,43);
        hash.put(2,34);
        System.out.println(hash.get());
        hash.put(3,52);
        System.out.println(hash.get());
        hash.put(4, 43);
        System.out.println(hash.get());
        System.out.println(hash.get(2));
        System.out.println("Hashtable size: "+hash.size());
        System.out.println(hash.resize);
        System.out.println(hash.get());
    }

}
