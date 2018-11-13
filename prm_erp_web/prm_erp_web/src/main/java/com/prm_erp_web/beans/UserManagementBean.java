package com.prm_erp_web.beans;

import static com.prm_erp_web.beans.OrganizationBean.fillOrganizationMasterByProxy;
import com.prm_erp_web.entityManager.Organization;
import com.prm_erp_web.hibernateConfig.HibernateConfigs;
import org.hibernate.Session;
import org.springframework.stereotype.Component;
import prm_erp.proxy.OrganizationProxy;

/**
 *
 * @author PDP_Shiva
 */
@Component
public class UserManagementBean {

    public Long createOrganization(OrganizationProxy organizationProxy) {

//        Session dbSession = HibernateConfigs.getDbSession();
        Organization organization = fillOrganizationMasterByProxy(new Organization(), organizationProxy);
//        dbSession.persist(organization);
//        HibernateConfigs.commit(dbSession);

        return organization.getId();

    }
}
