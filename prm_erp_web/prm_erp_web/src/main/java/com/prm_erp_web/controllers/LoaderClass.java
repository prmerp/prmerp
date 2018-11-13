package com.prm_erp_web.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.prm_erp_web.annotations.Secured;
import java.util.logging.Level;
import java.util.logging.Logger;
import prm_erp.utility.HTTPHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author PDP_Shiva
 */
@RestController
@RequestMapping("/login")
public class LoaderClass {

    @RequestMapping(value = "/authentication", method = RequestMethod.POST)
    @Secured
    public HTTPHelper authentication() {
        try {
            //        return HTTPHelper.createResponse("SucessFull", 200);
            return new HTTPHelper(200, "", "");
        } catch (JsonProcessingException ex) {
            Logger.getLogger(LoaderClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
