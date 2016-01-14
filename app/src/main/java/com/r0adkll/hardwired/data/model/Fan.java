package com.r0adkll.hardwired.data.model;

import com.ftinc.kit.util.Utils;

/**
 * Project: Hardwired
 * Package: com.r0adkll.hardwired.data.model
 * Created by drew.heavner on 1/12/16.
 */
public class Fan extends Component {

    public int getSpeed(){
        return convertSpeed(value);
    }

    public int getMinSpeed(){
        return convertSpeed(min);
    }

    public int getMaxSpeed(){
        return convertSpeed(max);
    }

    private int convertSpeed(String value){
        String raw = value.replace("RPM", "")
                .trim();
        return Utils.parseInt(raw, -1);
    }

}
