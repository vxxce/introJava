package keyValue;

/**
 * A <code>KeyValuePair</code> is a generically typed data structure that holds a single key-pair value.
 * Keys must implement the <code>Comparable</code> interface.
 *
 * @author Zachary Olpin
 *
 * @param <K> The key, must extend <code>Comparable</code>
 * @param <V> The value.
 */
public class KeyValuePair<K extends Comparable<K>, V> implements Comparable<KeyValuePair<K,V>>{
    private final K key;
    private final V value;

    /**
     * Initializes <code>key</code> and <code>value</code> fields. Keys must implement the <code>Comparable</code>
     * interface.
     *
     * @param key The key whose type must support the <code>Comparable</code> interface.
     * @param value The value.
     */
    public KeyValuePair(K key, V value) {
            this.key = key;
            this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    /**
     * Fulfills the <code>Comparable</code>contract by defining how KeyValuePairs are to be compared, e.g. while being
     * sorted. The comparison is determined by the inherited comparison for the <i>keys</i> only. As such, the keys'
     * type must implement <code>Comparable</code>.
     *
     * @param o The KeyValuePair this will be compared with.
     * @return A "weight" value.
     */
    @Override
    public int compareTo(KeyValuePair<K, V> o) {
        return this.getKey().compareTo(o.getKey());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KeyValuePair<?, ?> that = (KeyValuePair<?, ?>) o;

        if (!getKey().equals(that.getKey())) return false;
        return getValue().equals(that.getValue());
    }

    @Override
    public int hashCode() {
        int result = getKey().hashCode();
        result = 31 * result + getValue().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "(" + key + ", " + value + ")";
    }

}
