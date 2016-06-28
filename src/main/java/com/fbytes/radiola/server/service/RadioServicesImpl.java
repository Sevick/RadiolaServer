package com.fbytes.radiola.server.service;

import com.fbytes.radiola.server.dao.AbstractDao;
import com.fbytes.radiola.server.dao.RadioDAO;
import com.fbytes.radiola.server.dao.RadioDAOImpl;
import com.fbytes.radiola.server.model.Radio;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.sql.Blob;
import java.util.List;

/**
 * Created by S on 31.05.2016.
 */

@Service("RadioServicesImpl")
@Transactional
public class RadioServicesImpl implements RadioServices, InitializingBean {

    @Autowired
    RadioDAO radioDAO;

    public void persist(Radio radio) throws Exception {
        radioDAO.persist(radio);
    }


    public Radio getObjById(Integer id) throws Exception {
        return radioDAO.getRadioById(id);
    }


    public List getList() throws Exception {
        return radioDAO.getAllRadio();
    }


    public void deleteObjByKey(Integer id) throws Exception {
        radioDAO.deleteRadio(id);
    }


    public Blob getRadioImg(Integer id)throws Exception {
        return radioDAO.getRadioImg(id);
    }

    // ----------------- Init ------------------


    @PostConstruct
    public void postConstructInit(){
        System.out.println("RadioServicesImpl.postConstructInit");
    }


    public void afterPropertiesSet() throws Exception {
        System.out.println("RadioServicesImpl.afterPropertiesSet");
    }


    public void initBean(){
        System.out.println("RadioServicesImpl.initBean");
    }

    // ----------------- Destroy ------------------

}
