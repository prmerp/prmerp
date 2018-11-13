/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prm_erp_web.annotations;

import com.prm_erp_web.utilities.Permissions;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author PDP_Shiva
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)  
public @interface Secured {

    Permissions permissions() default Permissions.ALL;
}
