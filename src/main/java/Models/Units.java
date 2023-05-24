/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FPTSHOP
 */
public class Units {
    @SerializedName("bucket")
    @Expose
    private List<String> bucket = new ArrayList<>();

    public Units() {
    }

    public List<String> getBucket() {
        return bucket;
    }

    public void setBucket(List<String> bucket) {
        this.bucket = bucket;
    }
}
