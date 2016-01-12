package com.r0adkll.hardwired.data.model;

/**
 * Project: Hardwired
 * Package: com.r0adkll.hardwired.data.model
 * Created by drew.heavner on 1/12/16.
 */
public class HDD extends Component{

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

}
