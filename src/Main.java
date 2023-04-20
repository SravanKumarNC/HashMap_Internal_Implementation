

public class Main {
    public static void main(String[] args) {

        MyHashMap<Integer, String> mp = new MyHashMap<>();

        mp.put(12, "sravan");
        mp.put(33, "rajesh");
        mp.put(16, "naresh");
        mp.put(44, "gowtham");

        System.out.println(mp.get(44));


    }
}