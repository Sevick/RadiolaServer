package com.fbytes.radiola.server.dao;

import com.fbytes.radiola.server.model.Radio;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by S on 30.05.2016.
 */
public interface RadioDAO {
    public void persist(Radio radio) throws SQLException;
    public void updateRadio(Integer radio_id, Radio radio) throws SQLException;
    public Radio getRadioById(Integer radio_id) throws SQLException;
    public List<Radio> getAllRadio() throws SQLException;
    public void deleteRadio(Integer radio_id) throws SQLException;
    public List<Radio> getRadioByName(String name) throws SQLException;
    public Blob getRadioImg(Integer radio_id)throws SQLException;
}

