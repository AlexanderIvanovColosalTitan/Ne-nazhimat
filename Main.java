public class Main {
    public static void main(String[] args) throws Exception {
        Hash table = new Hash();
        table.put(1, 10);
        table.put(2, 20);
        table.put(3, 30);
        table.put(4, 40);
        // выводит 20
        System.out.println(table.get(1));
        table.remove(2);
        System.out.println(table.get(2));
        System.out.println(table.get(4));
    }

}
