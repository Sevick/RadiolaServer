package com.fbytes.radiola.server.service;

import com.fbytes.radiola.server.dao.RadioDAO;
import com.fbytes.radiola.server.dao.RadioGroupDAO;
import com.fbytes.radiola.server.model.Radio;
import com.fbytes.radiola.server.model.RadioGroup;
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

@Service("RadioGroupServicesImpl")
@Transactional
public class RadioGroupServicesImpl implements RadioGroupServices, InitializingBean {

    @Autowired
    RadioGroupDAO radioGroupDAO;


    public void updateRadioGroup(RadioGroup radioGroup) throws Exception {
        radioGroupDAO.updateRadioGroup(radioGroup.getId(),radioGroup);
    }

    public void addRadioGroup(RadioGroup radioGroup) throws Exception {
        radioGroupDAO.addRadioGroup(radioGroup);
    }


    public RadioGroup getRadioGroupById(Integer id) throws Exception {
        return radioGroupDAO.getRadioGroupById(id);
    }


    public List getRadioGroupList() throws Exception {
        return radioGroupDAO.getAllRadioGroups();
    }


    public void deleteRadioGroup(Integer id) throws Exception {
        radioGroupDAO.deleteRadioGroup(id);
    }


    public Blob getRadioGroupImg(Integer id)throws Exception {
        return radioGroupDAO.getRadioGroupImg(id);
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
