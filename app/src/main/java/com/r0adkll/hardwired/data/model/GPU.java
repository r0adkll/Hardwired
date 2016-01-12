package com.r0adkll.hardwired.data.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Project: Hardwired
 * Package: com.r0adkll.hardwired.data.model
 * Created by drew.heavner on 1/12/16.
 */
public class GPU extends Component {

    public Load getLoad(){

        if(components != null && !components.isEmpty()){
            for (Component component : components) {
                if(component.title.equalsIgnoreCase("load")){
                    if(component.components != null && !component.components.isEmpty()){
                        Component cmp = component.components.get(0);
                        return cmp.getComponent(Load.class);
                    }

                    break;
                }
            }
        }

        return null;
    }

    public Clock getCoreClock(){
        if(components != null && !components.isEmpty()){
            for (Component component : components) {
                if(component.title.equalsIgnoreCase("clocks")){
                    if(component.components != null && !component.components.isEmpty()){
                        for (Component clockCmp : component.components) {
                            if(clockCmp.title.toLowerCase().contains("core")){
                                return clockCmp.getComponent(Clock.class);
                            }
                        }
                    }
                }
            }
        }

        return null;
    }

    public Clock getMemoryClock(){
        if(components != null && !components.isEmpty()){
            for (Component component : components) {
                if(component.title.equalsIgnoreCase("clocks")){
                    if(component.components != null && !component.components.isEmpty()){
                        for (Component clockCmp : component.components) {
                            if(clockCmp.title.toLowerCase().contains("memory")){
                                return clockCmp.getComponent(Clock.class);
                            }
                        }
                    }
                }
            }
        }

        return null;
    }

    public Temperature getTemperature(){
        if(components != null && !components.isEmpty()){
            for (Component component : components) {
                if(component.title.equalsIgnoreCase("temperatures")){
                    if(component.components != null && !component.components.isEmpty()){
                        Component cmp = component.components.get(0);
                        return cmp.getComponent(Temperature.class);
                    }
                }
            }
        }

        return null;
    }

    public Fan getFan(){
        if(components != null && !components.isEmpty()){
            for (Component component : components) {
                if(component.title.equalsIgnoreCase("fans")){
                    if(component.components != null && !component.components.isEmpty()){
                        Component cmp = component.components.get(0);
                        return cmp.getComponent(Fan.class);
                    }
                }
            }
        }

        return null;
    }

}
