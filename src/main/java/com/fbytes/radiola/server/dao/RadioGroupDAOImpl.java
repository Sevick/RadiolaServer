package com.fbytes.radiola.server.dao;

/**
 * Created by S on 30.05.2016.
 */


import com.fbytes.radiola.server.model.Radio;
import com.fbytes.radiola.server.model.RadioGroup;
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

@Repository("radioGroupDAO")
@Transactional(propagation = Propagation.REQUIRED)
public class RadioGroupDAOImpl extends AbstractDao<Integer, RadioGroup> implements RadioGroupDAO {


    private static final String SELECT_QUERY = "FROM Radio";

    /*
    @PersistenceContext
    private EntityManager entityManager;
    */

    public void addRadioGroup(RadioGroup radioGroup) throws SQLException{
        persist(radioGroup);
    }


    public void updateRadioGroup(Integer RadioGroup_id, RadioGroup radioGroup) throws SQLException {

    }


    public List<RadioGroup> getAllRadioGroups() throws SQLException {

        Criteria criteria = createEntityCriteria();
        return (List<RadioGroup>) criteria.list();

/*
        Query query = entityManager.createQuery(SELECT_QUERY);
        List<Radio> radios = (List<Radio>) query.getResultList();
        return radios;
*/
    }

    public RadioGroup getRadioGroupById(Integer radioGroup_id) throws SQLException{
        return getByKey(radioGroup_id);
    }


    public void deleteRadioGroup(Integer radioGroup_id) throws SQLException {
        org.hibernate.Query query = getSession().createSQLQuery("delete from radiogroup where ID = :RadioGroup_id");
        query.setLong("RadioGroup_id", radioGroup_id);
        query.executeUpdate();
    }


    public List<RadioGroup> getRadioGroupByName(String name) throws SQLException {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("name", name));
        return (List<RadioGroup>) criteria.list();
    }

    public Blob getRadioGroupImg(Integer RadioGroup_id) throws SQLException {
        ResultSet rset = null;
        org.hibernate.Query query = getSession().createSQLQuery("select image from radiogroup where ID = :RadioGroup_id").addScalar("IMAGE", StandardBasicTypes.BLOB) ;
        query.setLong("RadioGroup_id", RadioGroup_id);
        return ((Blob) query.uniqueResult());
    }
}
