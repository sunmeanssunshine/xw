package LRU;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by xuw-e on 2018/11/1.
 */
public class LRUCache<K,V> extends LinkedHashMap<K,V> {
    private int maxEntries;
    public LRUCache(int maxEntries) {
        super(16, 0.75f, true);
        this.maxEntries = maxEntries;
    }
    @Override
    protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
        return this.size() > maxEntries;
    }

    public static void main(String[] args) {
        LRUCache<String, String> cache = new LRUCache<>(3);
        cache.put("a", "a");
        cache.put("b", "b");
        cache.put("c", "c");
        cache.get("a");
        cache.put("d", "d");
        System.out.println(cache);
        String s = "dd";
        ;
        System.out.println(s.indexOf("b"));
    }

}
