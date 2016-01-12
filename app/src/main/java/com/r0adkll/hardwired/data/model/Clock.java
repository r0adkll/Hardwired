package com.r0adkll.hardwired.data.model;

import com.ftinc.kit.util.Utils;

/**
 * Project: Hardwired
 * Package: com.r0adkll.hardwired.data.model
 * Created by drew.heavner on 1/12/16.
 */
public class Clock extends Component {

    public int getSpeedMhz(){
        return convertSpeed(value);
    }

    public int getMinSpeedMhz(){
        return convertSpeed(min);
    }

    public int getMaxSpeedMhz(){
        return convertSpeed(max);
    }

    public String getLabel(){
        return title.replace("CPU", "")
                .replace("GPU", "")
                .trim();
    }

    private int convertSpeed(String value){
        String raw = value.toLowerCase().replace("mhz", "").trim();
        return Utils.parseInt(raw, 0);
    }

}
