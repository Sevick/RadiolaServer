package com.fbytes.radiola.server.service;


import com.fbytes.radiola.server.dao.RadioStreamDAO;
import com.fbytes.radiola.server.model.RadioStream;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by S on 31.05.2016.
 */

@Service("RadioStreamServicesImpl")
@Transactional
public class RadioStreamServicesImpl implements RadioStreamServices, InitializingBean {

    @Autowired
    RadioStreamDAO radioStreamDAO;


    public void addRadioStream(RadioStream radioStream) throws Exception {
        radioStreamDAO.addRadioStream(radioStream);
    }


    public RadioStream getRadioStreamById(Integer id) throws Exception {
        return radioStreamDAO.getRadioStreamById(id);
    }


    public List getRadioStreamList() throws Exception {
        return radioStreamDAO.getAllRadioStream();
    }


    public void deleteRadioStream(Integer id) throws Exception {
        radioStreamDAO.deleteRadioStream(id);
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
