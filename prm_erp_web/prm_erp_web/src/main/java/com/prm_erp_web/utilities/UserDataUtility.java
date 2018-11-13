package com.prm_erp_web.utilities;

import java.util.logging.Level;
import java.util.logging.Logger;
import com.prm_erp_web.entityManager.UserMaster;

/**
 *
 * @author PDP_Shiva
 */
public class UserDataUtility {

    private static final Logger LOGGER = Logger.getLogger(UserDataUtility.class.getName());

    public static UserTrackManagerMaster setUserDataForUpdate(UserTrackManagerMaster managerMaster) {

        if (null == managerMaster) {
            LOGGER.log(Level.INFO, "NullPointer For Set UserData");
            return null;
        }

        UserMaster createdBy = managerMaster.getCreatedBy();
        long currentTimeMillis = System.currentTimeMillis();
        Long userId = UserSession.getUserId();
        UserMaster master = null == userId ? null : new UserMaster(userId);
        if (null == createdBy) {
            managerMaster.setCreatedBy(master);
            managerMaster.setCreatedDate(currentTimeMillis);
        }
        managerMaster.setUpdatedBy(master);
        managerMaster.setUpdatedDate(System.currentTimeMillis());
        return managerMaster;
    }
}
