package com.fbytes.radiola.server.controller;

import com.fbytes.radiola.server.model.Radio;
import com.fbytes.radiola.server.model.RadioGroup;
import com.fbytes.radiola.server.model.RadioGroupList;
import com.fbytes.radiola.server.service.RadioGroupServices;
import com.fbytes.radiola.server.service.RadioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.servlet.http.HttpServletResponse;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/rest")
@ResponseBody
public class AppRestController {

	private static final String template = "Echo test response: %s!";
    private final RequestMappingHandlerMapping handlerMapping;


    @Autowired
    public AppRestController(RequestMappingHandlerMapping handlerMapping) {
        this.handlerMapping = handlerMapping;
    }

    public Map<RequestMappingInfo, HandlerMethod> getMappingsList() {
        Map<RequestMappingInfo, HandlerMethod> mappingMap=this.handlerMapping.getHandlerMethods();
        return mappingMap;
    }


	@Autowired
	RadioServices radioServices;

    @Autowired
    RadioGroupServices radioGroupServices;

	@RequestMapping("/echotest")
	public String echoTest(@RequestParam(value="echo", defaultValue="") String echoStr) {
		return new String(String.format(template, echoStr));
	}

	@RequestMapping("/radiotest")
	public Radio radioTest() {
		return new Radio(1,"Test radio");
	}

	@RequestMapping("/getRadioList")
	public List<Radio> getRadioList() {
        List<Radio> radios = null;
        try {
            System.out.println("!!! getting list");
            radios = radioServices.getList();
            System.out.println("!!! got list");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return radios;

	}



    @RequestMapping("/getRadioGroupList")
    public RadioGroupList getRadioGroupList() {
        List<RadioGroup> radioGroups = null;
        RadioGroupList tmpGroupList= new RadioGroupList();
        try {
            radioGroups = radioGroupServices.getRadioGroupList();
            tmpGroupList.setItemList(radioGroups);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tmpGroupList;
    }


/*
    @RequestMapping("/getRadioGroupList")
    public List<RadioGroup> getRadioGroupList() {
        List<RadioGroup> radioGroups = null;
        try {
            System.out.println("!!! getting list");
            radioGroups = radioGroupServices.getRadioGroupList();

            System.out.println("!!! got list with "+radioGroups.size()+ "groups");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return radioGroups;
    }
*/




    @RequestMapping("/getRadioGroupByKey")
    public RadioGroup getRadioGroupByKey(@RequestParam(value="radiogroup_id", defaultValue="1") Integer radioGroupId) {
        RadioGroup radioGroup = null;
        try {
            radioGroup = radioGroupServices.getRadioGroupById(radioGroupId);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return radioGroup;
    }






	@RequestMapping(value="/getRadioImg", produces = MediaType.IMAGE_JPEG_VALUE)
	public void getRadioImg(@RequestParam(value="radio_id", defaultValue="1") Integer radioId, HttpServletResponse response) {
        response.setContentType("image/jpeg");

        Blob radioImgBlob = null;
        byte[] radioImgBin;
        try {
            radioImgBlob = radioServices.getRadioImg(radioId);
            response.getOutputStream().write(radioImgBlob.getBytes(1,(int) radioImgBlob.length()));
            //radioImgBlob.getBinaryStream().read(radioImgBin);
            //Base64.encode(radioImgBin);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}


    @RequestMapping(value="/getRadioGroupImg", produces = MediaType.IMAGE_JPEG_VALUE)
    public void getRadioGroupImg(@RequestParam(value="radioGroup_id", defaultValue="1") Integer radioGroupId, HttpServletResponse response) {
        response.setContentType("image/jpeg");

        Blob imgBlob = null;
        byte[] radioImgBin;
        try {
            imgBlob = radioGroupServices.getRadioGroupImg(radioGroupId);
            response.getOutputStream().write(imgBlob.getBytes(1,(int) imgBlob.length()));
            //radioImgBlob.getBinaryStream().read(radioImgBin);
            //Base64.encode(radioImgBin);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
