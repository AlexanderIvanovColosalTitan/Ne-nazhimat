public class Main {
    public static void main(String[] args) throws Exception{
        HashTable hash = new HashTable();
        hash.put(1,43);
        hash.put(2,34);
        hash.put(3, 77);
        System.out.println("Hashtable size: "+hash.size());
        hash.put(2,52);
        hash.put(6,43);
        hash.put(7,34);
        System.out.println("Hashtable size: "+hash.size());
        hash.put(8, 77);
        hash.put(9,52);
        hash.remove(2);
        System.out.println(hash.get(3));
        System.out.println("Hashtable size: "+hash.size());
        System.out.println(hash.resize);

    }
}