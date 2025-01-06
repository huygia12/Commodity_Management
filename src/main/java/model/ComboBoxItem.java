package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ComboBoxItem <T> {
    private String displayName; 
    private T id; 

    public ComboBoxItem(String displayName, T id) {
        this.displayName = displayName;
        this.id = id;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
