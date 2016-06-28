package com.fbytes.radiola.server.dao;

/**
 * Created by S on 30.05.2016.
 */


import com.fbytes.radiola.server.model.Radio;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository("radioDAO")
@Transactional(propagation = Propagation.REQUIRED)
public class RadioDAOImpl extends AbstractDao<Integer, Radio> implements RadioDAO {


    private static final String SELECT_QUERY = "FROM Radio";

    public void persist(Radio radio){
        persist(radio);
    }


    public void updateRadio(Integer Radio_id, Radio radio) throws SQLException {

    }


    public List<Radio> getAllRadio() throws SQLException {
        Criteria criteria = createEntityCriteria();
        return (List<Radio>) criteria.list();
    }

    public Radio getRadioById(Integer radio_id) throws SQLException{
        return getByKey(radio_id);
    }


    public void deleteRadio(Integer radio_id) throws SQLException {
        org.hibernate.Query query = getSession().createSQLQuery("delete from radio where ID = :Radio_id");
        query.setLong("Radio_id", radio_id);
        query.executeUpdate();
    }


    public List<Radio> getRadioByName(String name) throws SQLException {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("name", name));
        return (List<Radio>) criteria.list();
    }

    public Blob getRadioImg(Integer radio_id) throws SQLException {
        ResultSet rset = null;
        org.hibernate.Query query = getSession().createSQLQuery("select image from radio where ID = :Radio_id").addScalar("IMAGE", StandardBasicTypes.BLOB) ;
        query.setLong("Radio_id", radio_id);
        return ((Blob) query.uniqueResult());
    }
}
