package com.r0adkll.hardwired.data.model;

import android.support.annotation.IntDef;

import com.ftinc.kit.util.RxUtils;
import com.google.gson.annotations.SerializedName;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/**
 * This represents every component and stat of the api
 *
 * Project: Hardwired
 * Package: com.r0adkll.hardwired.data.model
 * Created by drew.heavner on 1/11/16.
 */
public class Component {

    public <T extends Component> T getComponent(Class<T> clazz){
        try {
            T cmp = clazz.newInstance();
            cmp.copy(this);
            return cmp;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }

    void copy(Component c) {
        id = c.id;
        title = c.title;
        components = c.components;
        value = c.value;
        min = c.min;
        max = c.max;
        imageUri = c.imageUri;
    }

    /***********************************************************************************************
     *
     * Constants
     *
     */

    public static final int COMPUTER = 1;
    public static final int MOTHERBOARD = 2;
    public static final int MEMORY = 4;
    public static final int CPU = 8;
    public static final int GRAPHICS = 16;
    public static final int HDD = 32;
    public static final int SSD = 64;
    public static final int UNKNOWN = 128;

    @IntDef({COMPUTER, MOTHERBOARD, MEMORY, CPU, GRAPHICS, HDD, SSD, UNKNOWN})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Components{}

    /***********************************************************************************************
     *
     * Fields
     *
     */

    public int id;

    @SerializedName("Text")
    public String title;

    @SerializedName("Children")
    public List<Component> components;

    @SerializedName("Value")
    public String value;

    @SerializedName("Min")
    public String min;

    @SerializedName("Max")
    public String max;

    @SerializedName("ImageURL")
    public String imageUri;

    /***********************************************************************************************
     *
     * Helper Methods
     *
     */

    @Components
    public int getType(){
        if(imageUri.endsWith("computer.png")){
            return COMPUTER;
        }else if(imageUri.endsWith("hdd.png")){
            if(title.toLowerCase().contains("ssd")){
                return SSD;
            }else{
                return HDD;
            }
        }else if(imageUri.endsWith("ati.png") || imageUri.endsWith("nvidia.png")){
            return GRAPHICS;
        }else if(imageUri.endsWith("ram.png")){
            return MEMORY;
        }else if(imageUri.endsWith("cpu.png")){
            return CPU;
        }else if(imageUri.endsWith("mainboard.png")){
            return MOTHERBOARD;
        }else{
            return UNKNOWN;
        }
    }

    @Override
    public String toString() {
        return "Component{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", components=" + components +
                ", value='" + value + '\'' +
                ", min='" + min + '\'' +
                ", max='" + max + '\'' +
                ", imageUri='" + imageUri + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Component component = (Component) o;

        if (id != component.id) return false;
        if (title != null ? !title.equals(component.title) : component.title != null) return false;
        if (components != null ? !components.equals(component.components) : component.components != null)
            return false;
        if (value != null ? !value.equals(component.value) : component.value != null) return false;
        if (min != null ? !min.equals(component.min) : component.min != null) return false;
        if (max != null ? !max.equals(component.max) : component.max != null) return false;
        return imageUri != null ? imageUri.equals(component.imageUri) : component.imageUri == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (components != null ? components.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        result = 31 * result + (min != null ? min.hashCode() : 0);
        result = 31 * result + (max != null ? max.hashCode() : 0);
        result = 31 * result + (imageUri != null ? imageUri.hashCode() : 0);
        return result;
    }

}
