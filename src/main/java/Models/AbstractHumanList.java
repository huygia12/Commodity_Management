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
 * @param <T>
 */
public abstract class AbstractHumanList<T extends AbstractHuman> {
    @SerializedName("")
    @Expose
    protected List<T> list = new ArrayList<>();
}
