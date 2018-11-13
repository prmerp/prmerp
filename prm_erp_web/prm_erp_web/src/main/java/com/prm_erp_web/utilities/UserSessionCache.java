/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prm_erp_web.utilities;

import prm_erp.utility.Constants;
import prm_erp.utility.CustomMap;

/**
 *
 * @author PDP_Shiva
 */
public class UserSessionCache {

    private static final CustomMap<String, UserSession> customMap = new CustomMap<>(Constants.Commons.DEFAULT_EXPIRYTIME);

    public static CustomMap<String, UserSession> get() {
        return customMap;
    }
}
