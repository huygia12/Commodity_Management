/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ultility;

/**
 *
 * @author FPTSHOP
 * @param <K>
 * @param <V>
 */
public class CustomPair<K, V> {
    private K k;
    private V v;

    public CustomPair(K k, V v) {
        this.k = k;
        this.v = v;
    }

    public K getK() {
        return k;
    }

    public void setK(K k) {
        this.k = k;
    }

    public V getV() {
        return v;
    }

    public void setV(V v) {
        this.v = v;
    }
    
    public<K, V> CustomPair of(K k, V v){
        return new CustomPair<>(k, v);
    }
    
}
