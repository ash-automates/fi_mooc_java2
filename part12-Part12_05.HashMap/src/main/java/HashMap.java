/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hachem
 * @param <K>
 * @param <V>
 */
public class HashMap<K, V> {
    private List<Pair<K,V>>[] buckets;
    private int entries;

    public HashMap() {
        this.buckets = new List[10];
        this.entries = 0;
    }
    
    public V get(K key) {
        int bucketIdx = Math.abs(key.hashCode() % this.buckets.length);
        List<Pair<K, V>> bucket = this.buckets[bucketIdx];
        if (bucket == null) {
            return null;
        }
        for (int i = 0; i < bucket.size(); i++) {
            if (bucket.value(i).getKey().equals(key)) {
                return bucket.value(i).getValue();
            }
        }
        return null;
    }
    
    public void add (K key, V value) {
        List<Pair<K, V>> bucket = this.getListFromKey(key);
        int existingKeyIdx = this.getIdxOfKey(bucket, key);
        if (existingKeyIdx != -1) {
            bucket.value(existingKeyIdx).setValue(value);
        } else {
            bucket.add(new Pair<>(key, value));
            this.entries += 1;
        }
        
        if ((double) this.entries / this.buckets.length > 0.75) {
            this.grow();
        }
    }
    
    public List<Pair<K, V>> getListFromKey(K key) {
        int bucketIdx = Math.abs(key.hashCode() % this.buckets.length);
        if (this.buckets[bucketIdx] == null) {
            this.buckets[bucketIdx] = new List<>();
        }
        return this.buckets[bucketIdx];
    }
    
    public int getIdxOfKey(List<Pair<K, V>> bucket, K key) {
        for (int i = 0; i < bucket.size(); i++) {
            if (bucket.value(i).getKey().equals(key)) {
                return i;
            }
        }
        return -1;
    }
    
    private void grow() {
        List<Pair<K, V>>[] newArray = new List[this.buckets.length * 2];
        for (int i = 0; i < this.buckets.length; i++) {
            this.copy(newArray, i);
        }
        this.buckets = newArray;
    }
    
    private void copy(List<Pair<K, V>>[] newArray, int i)  {
        List<Pair<K, V>> bucket = this.buckets[i];
        if (bucket == null) {
            return;
        }
        for (int j = 0; j < bucket.size(); j++) {
            K key = bucket.value(j).getKey();                                
            int newIdx = Math.abs(key.hashCode() % newArray.length);
            if (newArray[newIdx] == null) { 
                newArray[newIdx] = new List<>();
            }
            V value = bucket.value(j).getValue();
            newArray[newIdx].add(new Pair<>(key, value));
        }
    }
    
    public V remove(K key) {
        List<Pair<K, V>> bucketOfKey = this.getListFromKey(key);
        if (bucketOfKey.size() == 0) {
            return null;
        }
        int idxOfKey = this.getIdxOfKey(bucketOfKey, key);
        if (idxOfKey < 0) {
            return null;
        } else {
            Pair<K, V> pair = bucketOfKey.value(idxOfKey);
            bucketOfKey.remove(pair);
            this.entries -= 1;
            return pair.getValue();
        }
    }
}
