package prm_erp.utility;

import java.util.List;

/**
 *
 * @author PDP_Shiva
 */
public class ListUtility {

    public static Boolean isNullOrEmpty(List list) {
        return (null == list || list.isEmpty());
    }

    public static Boolean getBooleanObjectFromList(List list) {
        if (isNullOrEmpty(list)) {
            return null;
        } else {
            return (Boolean) list.get(0);
        }
    }
    public static Long getLongObjectFromList(List list) {
        if (isNullOrEmpty(list)) {
            return null;
        } else {
            return (Long) list.get(0);
        }
    }

}
