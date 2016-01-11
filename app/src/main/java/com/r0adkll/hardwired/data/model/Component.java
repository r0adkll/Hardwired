package com.r0adkll.hardwired.data.model;

import android.support.annotation.IntDef;

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

    /***********************************************************************************************
     *
     * Constants
     *
     */

    public static final int COMPUTER = 0;
    public static final int MOTHERBOARD = 1;
    public static final int MEMORY = 2;
    public static final int CPU = 3;
    public static final int GRAPHICS = 4;
    public static final int HDD = 5;
    public static final int SSD = 6;
    public static final int UNKNOWN = 7;

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

}
