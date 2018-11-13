package com.prm_erp_web.utilities;

/**
 *
 * @author PDP_Shiva
 */
public interface UserTrackManagerProxy {

    public Long getUpdatedBy();

    public void setUpdatedBy(Long master);

    public Long getUpdatedDate();

    public void setUpdatedDate(Long date);

    public Long getCreatedBy();

    public void setCreatedBy(Long master);

    public Long getCreatedDate();

    public void setCreatedDate(Long date);
    
}
