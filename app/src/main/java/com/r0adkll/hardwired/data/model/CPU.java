package com.r0adkll.hardwired.data.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Project: Hardwired
 * Package: com.r0adkll.hardwired.data.model
 * Created by drew.heavner on 1/12/16.
 */
public class CPU extends Component {

    /**
     * Get the CPU's overall total load
     *
     * @return
     */
    public Load getTotalLoad(){
        if(components != null && !components.isEmpty()){
            for (Component component : components) {
                if(component.title.equalsIgnoreCase("load")){
                    for (Component loadCmp : component.components) {
                        if(loadCmp.title.toLowerCase().contains("total")) {
                            return loadCmp.getComponent(Load.class);
                        }
                    }
                }
            }
        }

        return null;
    }

    /**
     * Get the cpu's core load values
     * @return
     */
    public List<Load> getCoreLoads(){
        List<Load> loads = new ArrayList<>(4);

        // Iterate through children for a load component
        if(components != null && !components.isEmpty()){
            for (Component component : components) {
                if(component.title.equalsIgnoreCase("load")){
                    for (Component loadCmp : component.components) {
                        if(!loadCmp.title.toLowerCase().contains("total")) {
                            loads.add(loadCmp.getComponent(Load.class));
                        }
                    }
                    break;
                }
            }
        }

        return loads;
    }

    /**
     * Get the CPU's Bus Speed Clock
     * @return
     */
    public Clock getBusClock(){
        if(components != null && !components.isEmpty()){
            for (Component component : components) {
                if(component.title.equalsIgnoreCase("clocks")){
                    for (Component clockCmp : component.components) {
                        if(clockCmp.title.toLowerCase().contains("bus")) { // Exclude bus speed
                            return clockCmp.getComponent(Clock.class);
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * Get the cpu's core clock speeds in mhz
     * @return
     */
    public List<Clock> getCoreClocks(){
        List<Clock> clocks = new ArrayList<>();

        if(components != null && !components.isEmpty()){
            for (Component component : components) {
                if(component.title.equalsIgnoreCase("clocks")){
                    for (Component clockCmp : component.components) {
                        if(!clockCmp.title.toLowerCase().contains("bus")) { // Exclude bus speed
                            clocks.add(clockCmp.getComponent(Clock.class));
                        }
                    }
                    break;
                }
            }
        }

        return clocks;
    }


}
