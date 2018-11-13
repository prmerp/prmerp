/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prm_erp_web.utilities;

/**
 *
 * @author PDP_Shiva
 * @param <T>
 */
public class ResponceData<T> {

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * @return the data
     */
    public T getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(T data) {
        this.data = data;
    }

    private ResponceData() {
    }

    public ResponceData(int status, T data) {
        this.status = status;
        this.data = data;
    }

    public ResponceData(int status) {
        this.status = status;
    }

    public ResponceData(T data) {
        this.data = data;
    }

    private int status;
    private T data;

}
