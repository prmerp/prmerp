package com.prm_erp_web.utilities;

import com.prm_erp_web.entityManager.UserMaster;

/**
 *
 * @author PDP_Shiva
 */
public interface UserTrackManagerMaster {

    public UserMaster getUpdatedBy();

    public void setUpdatedBy(UserMaster master);

    public Long getUpdatedDate();

    public void setUpdatedDate(Long date);

    public UserMaster getCreatedBy();

    public void setCreatedBy(UserMaster master);

    public Long getCreatedDate();

    public void setCreatedDate(Long date);

}
