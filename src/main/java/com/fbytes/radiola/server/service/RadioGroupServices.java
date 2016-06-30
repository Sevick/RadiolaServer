package com.fbytes.radiola.server.service;

import com.fbytes.radiola.server.model.Radio;
import com.fbytes.radiola.server.model.RadioGroup;

import java.sql.Blob;
import java.util.List;

/**
 * Created by S on 31.05.2016.
 */
public interface RadioGroupServices {
    public void updateRadioGroup(RadioGroup radioGroup)throws Exception;
    public void addRadioGroup(RadioGroup radioGroup) throws Exception;
    public RadioGroup getRadioGroupById(Integer id) throws Exception;
    public List getRadioGroupList() throws Exception;
    public void deleteRadioGroup(Integer id) throws Exception;
    public Blob getRadioGroupImg(Integer id) throws Exception;
}



