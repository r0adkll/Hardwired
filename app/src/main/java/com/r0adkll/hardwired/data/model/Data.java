package com.r0adkll.hardwired.data.model;

import android.support.annotation.IntDef;

import com.ftinc.kit.util.Utils;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Project: Hardwired
 * Package: com.r0adkll.hardwired.data.model
 * Created by drew.heavner on 1/12/16.
 */
public class Data extends Component {

    public static final int USED = 0;
    public static final int AVAILABLE = 1;
    public static final int GENERAL = 3;

    @IntDef({USED, AVAILABLE, GENERAL})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Type {}

    @Type
    public int getDataType(){
        if(title.toLowerCase().contains("used")){
            return USED;
        }else if(title.toLowerCase().contains("available")){
            return AVAILABLE;
        }
        return GENERAL;
    }

    public float getAmount(){
        return convertAmount(value);
    }

    public float getMinAmount(){
        return convertAmount(min);
    }

    public float getMaxAmount(){
        return convertAmount(max);
    }

    private float convertAmount(String value){
        String raw = value.replace("GB", "").trim();
        return Utils.parseFloat(raw, -1f);
    }

}
