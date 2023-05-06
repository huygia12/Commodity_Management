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

    public IDGenerator() {
    }

    public IDGenerator(Map<String, Integer> bucket) {
        this.bucket = bucket;
    }
    
    
    public Map<String, Integer> getBucket() {
        return bucket;
    }

    public String generateID(String key, int numberOfSequence){
        int value = 0;
        if(this.bucket.containsKey(key)){
            value = this.bucket.get(key);
            value++;
        }
        this.bucket.put(key, value);
        return String.format("%0"+numberOfSequence+"d", value);
    }
}
