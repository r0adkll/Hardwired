package com.r0adkll.hardwired.data.model;

/**
 * Project: Hardwired
 * Package: com.r0adkll.hardwired.data.model
 * Created by drew.heavner on 1/12/16.
 */
public class RAM extends Component {

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

    public Data getUsedMemory(){
        if(components != null && !components.isEmpty()){
            for (Component component : components) {
                if(component.title.equalsIgnoreCase("data")){
                    if(component.components != null && !component.components.isEmpty()){
                        for (Component dataCmp : component.components) {
                            Data data = dataCmp.getComponent(Data.class);
                            if(data.getDataType() == Data.USED){
                                return data;
                            }
                        }
                    }

                    break;
                }
            }
        }

        return null;
    }

    public Data getAvailableMemory(){
        if(components != null && !components.isEmpty()){
            for (Component component : components) {
                if(component.title.equalsIgnoreCase("data")){
                    if(component.components != null && !component.components.isEmpty()){
                        for (Component dataCmp : component.components) {
                            Data data = dataCmp.getComponent(Data.class);
                            if(data.getDataType() == Data.AVAILABLE){
                                return data;
                            }
                        }
                    }

                    break;
                }
            }
        }

        return null;
    }

    public float getTotalMemory(){
        Data used = getUsedMemory();
        Data available = getAvailableMemory();

        if(used != null && available != null){
            return used.getAmount() + available.getAmount();
        }

        return 0f;
    }

}
