/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prm_erp.utility;

/**
 *
 * @author PDP_Shiva
 */
public class StringUtility {

    public static Boolean isNullOrEmpty(String string) {
        return (null == string || string.length() <= 0);
    }
}
