package com.prm_erp_web.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prm_erp_web.beans.PersonBean;
import com.prm_erp_web.utilities.FileUtility;
import java.util.List;
import prm_erp.utility.HTTPHelper;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import prm_erp.proxy.PersonProxy;

/**
 *
 * @author PDP_Shiva
 */
@RestController
@RequestMapping("/person")
public class PersonServices {

    private static final Logger LOG = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private FileUtility fileUtility;
    @Autowired
    private PersonBean personBean;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public HTTPHelper save(@RequestBody PersonProxy personProxy) {
        try {
            personProxy = personBean.save(personProxy);
            return new HTTPHelper(HttpStatus.OK.value(), personProxy, "Person Save Successfully");
        } catch (Exception e) {
            try {
                LOG.log(Level.INFO, e.getMessage());
                e.printStackTrace();
                return new HTTPHelper(HttpStatus.INTERNAL_SERVER_ERROR.value(), null, "Internal Server Error");
            } catch (JsonProcessingException ex) {
                Logger.getLogger(PersonServices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    @RequestMapping(value = "/saveMultipart", method = RequestMethod.POST)
    public HTTPHelper saveMultipart(@RequestParam("additionalData") String data, @RequestParam("file") MultipartFile uploadfile) {
        try {
            if (uploadfile.isEmpty()) {
                return new HTTPHelper(HttpStatus.OK.value(), null, "please select a file!");
            }
            PersonProxy save = personBean.save(objectMapper.readValue(data, PersonProxy.class));
            String logoPath = save.getLogoPath();

            fileUtility.saveProfilePic(uploadfile, logoPath);
            return new HTTPHelper(HttpStatus.OK.value(), null, "Person Save Successfully");
        } catch (Exception e) {
            try {
                LOG.log(Level.INFO, e.getMessage());
                return new HTTPHelper(HttpStatus.INTERNAL_SERVER_ERROR.value(), null, "Internal Server Error");
            } catch (JsonProcessingException ex) {
                Logger.getLogger(PersonServices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    @RequestMapping(value = "/getList", method = RequestMethod.GET)
    public HTTPHelper getList() {
        try {
            List<PersonProxy> personProxys = personBean.getList();
            return new HTTPHelper(HttpStatus.OK.value(), personProxys, "Person Save Successfully");
        } catch (Exception e) {
            try {
                LOG.log(Level.INFO, e.getMessage());
                e.printStackTrace();
                return new HTTPHelper(HttpStatus.INTERNAL_SERVER_ERROR.value(), null, "Internal Server Error");
            } catch (JsonProcessingException ex) {
                Logger.getLogger(PersonServices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
}
