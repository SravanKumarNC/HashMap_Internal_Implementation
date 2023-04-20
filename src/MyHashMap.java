public class MyHashMap<K, V> {

    private static final int INITIAL_SIZE = 1<<4; //16;
    private static final int MAXIMUM_SIZE = 1<<30;

    Entry[] hashTable;

    public MyHashMap(){
        hashTable = new Entry[INITIAL_SIZE];
    }

    public MyHashMap(int capacity){
        int tableSize = getTableSize(capacity);
        hashTable = new Entry[tableSize];
    }

    private int getTableSize(int capacity) {
        int n = capacity - 1;
        n |= n >>>1;
        n |= n >>>2;
        n |= n >>>4;
        n |= n >> 8;
        n |= n >> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_SIZE) ? MAXIMUM_SIZE : n + 1;
    }


    static class  Entry<K, V>{
        public K key;
        public V value;

        public Entry next;
        Entry(K key, V value){
            this.key = key;
            this.value = value;
        }
    }

    public void put(K key, V value){
        int hashCode = key.hashCode() % hashTable.length;
        Entry node = hashTable[hashCode];

        if(node == null){
            Entry newNode = new Entry(key, value);
            hashTable[hashCode] = newNode;
        }else{
            Entry previousNode = node;
            while(node != null){
                if(node.key == key){
                    node.value = value;
                    return;
                }
                previousNode = node;
                node = node.next;
            }
            Entry newNode = new Entry(key, value);
            previousNode.next = newNode;
        }
    }

    public V  get(K key){
        int hashcode = key.hashCode() % hashTable.length;
        Entry node = hashTable[hashcode];

        while(node != null){
            if(node.key.equals(key)){
                return (V)node.value;
            }
            node = node.next;
        }
        return null;
    }


}
