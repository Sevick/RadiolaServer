package com.fbytes.radiola.server.dao;



import com.fbytes.radiola.server.model.RadioStream;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by S on 30.05.2016.
 */
public interface RadioStreamDAO {
    public void addRadioStream(RadioStream radioStream) throws SQLException;
    public void updateRadioStream(Integer radioStream_id, RadioStream radioStream) throws SQLException;
    public RadioStream getRadioStreamById(Integer radioStream_id) throws SQLException;
    public List<RadioStream> getAllRadioStream() throws SQLException;
    public void deleteRadioStream(Integer radioStream_id) throws SQLException;
}

