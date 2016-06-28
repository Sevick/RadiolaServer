package com.fbytes.radiola.server.service;

import com.fbytes.radiola.server.model.Radio;

import java.sql.Blob;
import java.util.List;

/**
 * Created by S on 31.05.2016.
 */
public interface RadioServices {
    public void persist(Radio radio) throws Exception;
    public Radio getObjById(Integer id) throws Exception;
    public List getList() throws Exception;
    public void deleteObjByKey(Integer id) throws Exception;
    public Blob getRadioImg(Integer id) throws Exception;
}



