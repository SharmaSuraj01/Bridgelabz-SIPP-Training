package HashMaps;
class MyHashMap<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    
    private Entry<K, V>[] buckets;
    private int size;
    private float loadFactor;
    static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;
        
        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    public MyHashMap() {
        this.buckets = new Entry[DEFAULT_CAPACITY];
        this.size = 0;
        this.loadFactor = DEFAULT_LOAD_FACTOR;
    }
    private int hash(K key) {
        return key == null ? 0 : Math.abs(key.hashCode()) % buckets.length;
    }
    public void put(K key, V value) {
        int index = hash(key);
        Entry<K, V> entry = buckets[index];
        while (entry != null) {
            if ((key == null && entry.key == null) || 
                (key != null && key.equals(entry.key))) {
                entry.value = value;
                return;
            }
            entry = entry.next;
        }
        Entry<K, V> newEntry = new Entry<>(key, value);
        newEntry.next = buckets[index];
        buckets[index] = newEntry;
        size++;
        if ((float) size / buckets.length > loadFactor) {
            resize();
        }
    }
    
    public V get(K key) {
        int index = hash(key);
        Entry<K, V> entry = buckets[index];
        
        while (entry != null) {
            if ((key == null && entry.key == null) || 
                (key != null && key.equals(entry.key))) {
                return entry.value;
            }
            entry = entry.next;
        }
        
        return null; 
    }
    public V remove(K key) {
        int index = hash(key);
        Entry<K, V> entry = buckets[index];
        Entry<K, V> prev = null;
        
        while (entry != null) {
            if ((key == null && entry.key == null) || 
                (key != null && key.equals(entry.key))) {
                if (prev == null) {
                    buckets[index] = entry.next;
                } else {
                    prev.next = entry.next;
                }
                size--;
                return entry.value;
            }
            prev = entry;
            entry = entry.next;
        }
        
        return null; // Key not found
    }
    private void resize() {
        Entry<K, V>[] oldBuckets = buckets;
        buckets = new Entry[oldBuckets.length * 2];
        size = 0;
        for (Entry<K, V> entry : oldBuckets) {
            while (entry != null) {
                put(entry.key, entry.value);
                entry = entry.next;
            }
        }
    }
    
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
}

public class CustomHashMap {
    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        
        System.out.println("Value for key 'one': " + map.get("one"));
        System.out.println("Value for key 'two': " + map.get("two"));
        
        map.put("two", 22);
        System.out.println("Updated value for key 'two': " + map.get("two"));
        
        map.remove("one");
        System.out.println("Value for key 'one' after removal: " + map.get("one"));
        
        System.out.println("Map size: " + map.size());
    }
}