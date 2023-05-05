/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.Map;

/**
 *
 * @author FPTSHOP
 */
public class IDGenerator {
    private Map<String, Integer> bucket;
    private int numberOfSequence;

    public IDGenerator() {
    }

    public IDGenerator(Map<String, Integer> bucket, int numberOfSequence) {
        this.bucket = bucket;
        this.numberOfSequence = numberOfSequence;
    }
    
    
    public Map<String, Integer> getBucket() {
        return bucket;
    }

    public int getNumberOfSequence() {
        return numberOfSequence;
    }

    public void setNumberOfSequence(int numberOfSequence) {
        this.numberOfSequence = numberOfSequence;
    }
    
    public String generateID(String key){
        int value = 0;
        if(this.bucket.containsKey(key)){
            value = this.bucket.get(key);
            value++;
        }
        this.bucket.put(key, value);
        return String.format("%0"+this.numberOfSequence+"d", value);
    }
}
