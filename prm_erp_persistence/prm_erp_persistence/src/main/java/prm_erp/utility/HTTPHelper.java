/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prm_erp.utility;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.Serializable;

/**
 *
 * @author PDP_Shiva
 */
public class HTTPHelper implements Serializable {

    /**
     * @return the status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    private Integer status;
    private String data;
    private String message;

    public HTTPHelper() {
    }

    public HTTPHelper(Integer status, Object data, String message) throws JsonProcessingException {

        this.status = status;
        this.data = null == data ? "{}" : new ObjectMapper().writeValueAsString(data);
        this.message = message;
    }
}
