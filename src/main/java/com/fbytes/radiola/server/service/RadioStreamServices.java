package com.fbytes.radiola.server.service;



import com.fbytes.radiola.server.model.RadioStream;

import java.util.List;

/**
 * Created by S on 31.05.2016.
 */
public interface RadioStreamServices {
    public void addRadioStream(RadioStream radioStream) throws Exception;
    public RadioStream getRadioStreamById(Integer id) throws Exception;
    public List getRadioStreamList() throws Exception;
    public void deleteRadioStream(Integer id) throws Exception;
}



