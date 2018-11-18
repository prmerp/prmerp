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
}
