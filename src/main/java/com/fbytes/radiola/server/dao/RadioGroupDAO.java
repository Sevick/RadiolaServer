package com.fbytes.radiola.server.dao;

import com.fbytes.radiola.server.model.Radio;
import com.fbytes.radiola.server.model.RadioGroup;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by S on 30.05.2016.
 */
public interface RadioGroupDAO {
    public void addRadioGroup(RadioGroup radioGroup) throws SQLException;
    public void updateRadioGroup(Integer Group_id, RadioGroup radioGroup) throws SQLException;
    public RadioGroup getRadioGroupById(Integer radioGroup_id) throws SQLException;
    public List<RadioGroup> getAllRadioGroups() throws SQLException;
    public void deleteRadioGroup(Integer radioGroup_id) throws SQLException;
    public List<RadioGroup> getRadioGroupByName(String name) throws SQLException;
    public Blob getRadioGroupImg(Integer RadioGroup_id)throws SQLException;
}

