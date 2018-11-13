/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prm_erp.utility;

import java.util.Map;

/**
 *
 * @author PDP_Shiva
 */
public class MapUtility {

    public static Boolean isNullOrEmpty(Map map) {
        return (null == map || map.isEmpty());
    }
}
