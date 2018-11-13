/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prm_erp.utility;

import java.time.LocalDate;
import java.time.ZoneOffset;

/**
 *
 * @author PDP_Shiva
 */
public class DateAndTimeUtils {

    public static Long localDateToMilisecond(LocalDate localDate) {
        if (null == localDate) {
            return null;
        }
        LocalDate value = localDate;
        return value.atStartOfDay(ZoneOffset.UTC).toInstant().toEpochMilli();
    }
}
