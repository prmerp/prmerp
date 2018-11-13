/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prm_erp_web.beans;

import com.prm_erp_web.entityManager.ContactNumbers;
import com.prm_erp_web.entityManager.Organization;
import com.prm_erp_web.entityManager.OrganizationType;
import com.prm_erp_web.hibernateConfig.HibernateConfigs;
import com.prm_erp_web.utilities.UserDataUtility;
import org.hibernate.Session;
import prm_erp.proxy.OrganizationProxy;

/**
 *
 * @author PDP_Shiva
 */
public class OrganizationBean {

    public static Organization fillOrganizationMasterByProxy(Organization organization, OrganizationProxy organizationProxy) {
        Long organizationType = organizationProxy.getOrganizationType();
        Long contactNo = organizationProxy.getContactNo();
        organization.setOrganizationName(organizationProxy.getOrganizationName());
        organization.setContactPerson(organizationProxy.getContactPerson());
        organization.setContactNo(null == contactNo ? null : new ContactNumbers(contactNo));
        organization.setEmail(organizationProxy.getEmail());
        organization.setFaxNo(organizationProxy.getFaxNo());
        organization.setGstNo(organizationProxy.getGstNo());
        organization.setIsActive(organizationProxy.isIsActive());
        organization.setOrganizationCode(organizationProxy.getOrganizationCode());
        organization.setWebSite(organizationProxy.getWebSite());
        organization.setOrganizationType(null == organizationType ? null : new OrganizationType(organizationType));
        organization.setDescription(organizationProxy.getDescription());
        organization = (Organization) UserDataUtility.setUserDataForUpdate(organization);
        return organization;
    }

    public Long createOrganization(OrganizationProxy organizationProxy) {
//
//        Session dbSession = HibernateConfigs.getDbSession();
        Organization organization = fillOrganizationMasterByProxy(new Organization(), organizationProxy);
//        dbSession.persist(organization);
//        HibernateConfigs.commit(dbSession);

        return organization.getId();

    }
}
