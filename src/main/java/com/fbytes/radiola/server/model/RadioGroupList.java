package com.fbytes.radiola.server.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by S on 27.06.2016.
 */
public class RadioGroupList implements Serializable{

    protected String name;
    protected Integer listVersion;
    protected List<RadioGroup> itemList;

    public RadioGroupList() {
    }

    public RadioGroupList(List<RadioGroup> radioDbList){
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getListVersion() {
        return listVersion;
    }

    public void setListVersion(Integer listVersion) {
        this.listVersion = listVersion;
    }

    public List<RadioGroup> getItemList() {
        return itemList;
    }

    public void setItemList(List<RadioGroup> itemList) {
        this.itemList = itemList;
    }
}
