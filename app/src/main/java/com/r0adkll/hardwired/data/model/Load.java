package com.r0adkll.hardwired.data.model;

import com.ftinc.kit.util.Utils;

/**
 * Project: Hardwired
 * Package: com.r0adkll.hardwired.data.model
 * Created by drew.heavner on 1/12/16.
 */
public class Load extends Component {

    public float getValue(){
        return convertToPercent(value);
    }

    public float getMin(){
        return convertToPercent(min);
    }

    public float getMax(){
        return convertToPercent(max);
    }

    public String getLabel(){
        return title.replace("CPU", "")
                .replace("GPU", "")
                .trim();
    }

    private float convertToPercent(String value){
        String raw = value.replace("%", "").trim();
        return Utils.parseFloat(raw, 0f);
    }

}
