package com.fbytes.radiola.server.dao;

/**
 * Created by S on 30.05.2016.
 */


import com.fbytes.radiola.server.model.RadioStream;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Repository("radioStreamDAO")
@Transactional(propagation = Propagation.REQUIRED)
public class RadioStreamDAOImpl extends AbstractDao<Integer, RadioStream> implements RadioStreamDAO {


    private static final String SELECT_QUERY = "FROM Stream";

    public void addRadioStream(RadioStream radioStream) throws SQLException{
        persist(radioStream);
    }


    public void updateRadioStream(Integer RadioStream_id, RadioStream radioStream) throws SQLException {

    }


    public List<RadioStream> getAllRadioStream() throws SQLException {
        Criteria criteria = createEntityCriteria();
        return (List<RadioStream>) criteria.list();
    }

    public RadioStream getRadioStreamById(Integer radioStream_id) throws SQLException{
        return getByKey(radioStream_id);
    }


    public void deleteRadioStream(Integer radioStream_id) throws SQLException {
        org.hibernate.Query query = getSession().createSQLQuery("delete from radio where ID = :RadioStream_id");
        query.setLong("RadioStream_id", radioStream_id);
        query.executeUpdate();
    }


    public List<RadioStream> getRadioStreamByName(String name) throws SQLException {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("name", name));
        return (List<RadioStream>) criteria.list();
    }

}
